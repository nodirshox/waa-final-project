package uz.spiders.propertymanagement.services.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.spiders.propertymanagement.dto.AddressDTO;
import uz.spiders.propertymanagement.dto.PictureDTO;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.dto.PropertyPartialUpdateDTO;
import uz.spiders.propertymanagement.entities.Picture;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.entities.Property.ListingType;
import uz.spiders.propertymanagement.entities.Property.PropertyType;
import uz.spiders.propertymanagement.entities.QProperty;
import uz.spiders.propertymanagement.exceptions.ResourceNotFoundException;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.services.PropertyService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final ModelMapper mapper;

    @Override
    public PropertyDTO create(PropertyDTO propertyDTO) {
        propertyDTO.setCreatedAt(LocalDateTime.now());
        propertyDTO.setStatus(Property.PropertyStatus.OPEN);
        var property = mapper.map(propertyDTO, Property.class);
        Property created = propertyRepository.save(property);
        var newProperty = mapper.map(created, PropertyDTO.class);
        return newProperty;
    };

    @Override
    public PropertyDTO getById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The property not found");
        }
        return mapper.map(property, PropertyDTO.class);
    }

    @Override
    @Transactional
    public PropertyDTO update(Long id, PropertyDTO propertyDTO) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The property not found");
        }

        property.setPrice(propertyDTO.getPrice());
        property.setNumberOfRooms(propertyDTO.getNumberOfRooms());
        property.setListingType(propertyDTO.getListingType());
        property.setType(propertyDTO.getType());
        property.setStatus(propertyDTO.getStatus());
        property.getAddress().setCity(propertyDTO.getAddress().getCity());
        property.getAddress().setZip(propertyDTO.getAddress().getZip());
        property.getAddress().setState(propertyDTO.getAddress().getState());
        property.getAddress().setStreet(propertyDTO.getAddress().getStreet());
        property.setUpdatedAt(LocalDateTime.now());

        return mapper.map(property, PropertyDTO.class);
    }

    @Override
    public List<PropertyDTO> latestRented() {
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        List<Property> properties = propertyRepository.findTop10ByStatusOrderByCreatedAtDesc(Property.PropertyStatus.RENTED);

        for (Property property: properties) {
            propertyDTOS.add(mapper.map(property, PropertyDTO.class));
        }

        return propertyDTOS;
    }

    @Override
    public Page<Property> filter(Pageable page, AddressDTO address, ListingType listing, PropertyType type,
                                 Integer rooms, Double price) {
        QProperty property = QProperty.property;
        List<BooleanExpression> predicates = getPropertyPredicates(property, listing, type, rooms, price);
        predicates.addAll(getAddressPredicates(property, address));

        if(!predicates.isEmpty()){
            BooleanExpression finalPredicate = predicates.stream()
                    .reduce(Expressions.asBoolean(Boolean.valueOf(true)).isTrue(), (p1, p2) -> p1.and(p2));
            return propertyRepository.findAll(finalPredicate, page);
        }
        return propertyRepository.findAll(page);
    }

    @Override
    public PropertyDTO partialUpdate(Long id, PropertyPartialUpdateDTO propertyDTO) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if(optionalProperty.isPresent()){
            Property property = optionalProperty.get();
            if(propertyDTO.getListingType() != null){
                property.setListingType(propertyDTO.getListingType());
            }
            if(propertyDTO.getPrice() != null){
                property.setPrice(propertyDTO.getPrice());
            }
            if(propertyDTO.getNumberOfRooms() != null){
                property.setNumberOfRooms(propertyDTO.getNumberOfRooms());
            }
            if(propertyDTO.getStatus() != null){
                property.setStatus(propertyDTO.getStatus());
            }
            if(propertyDTO.getType() != null){
                property.setType(propertyDTO.getType());
            }
            property = propertyRepository.save(property);
            return mapper.map(property, PropertyDTO.class);
        }else{
            throw new ResourceNotFoundException("Property with id = " + id + " does not exist");
        }
    }

    private List<BooleanExpression>  getAddressPredicates(QProperty property, AddressDTO address){
        List<BooleanExpression> predicates = new ArrayList<>();
        if(address != null){
            if(address.getState() != null && !address.getState().isBlank()){
                predicates.add(property.address.state.equalsIgnoreCase(address.getState()));
            }
            if(address.getCity() != null && !address.getCity().isBlank()){
                predicates.add(property.address.city.equalsIgnoreCase(address.getCity()));
            }
            if(address.getStreet() != null && !address.getStreet().isBlank()){
                predicates.add(property.address.street.equalsIgnoreCase(address.getStreet()));
            }
            if(address.getZip() != null && !address.getZip().isBlank()){
                predicates.add(property.address.zip.eq(address.getZip()));
            }
        }
        return predicates;
    }

    private List<BooleanExpression> getPropertyPredicates(QProperty property, ListingType listing, PropertyType type, Integer rooms, Double price){
        List<BooleanExpression> predicates = new ArrayList<>();
        if(listing != null){
            predicates.add(property.listingType.eq(listing));
        }
        if(type != null){
            predicates.add(property.type.eq(type));
        }
        if(rooms != null){
            predicates.add(property.numberOfRooms.eq(rooms));
        }
        if(price != null){
            predicates.add(property.price.eq(price));
        }
        return predicates;
    }

    @Transactional
    @Override
    public PropertyDTO updateImages(Long id, List<PictureDTO> pictureDTOS) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            throw new ResourceNotFoundException("Property with id = " + id + " does not exist");
        }

        for(PictureDTO img : pictureDTOS) {
            property.addPicture(mapper.map(img, Picture.class));
        }

        return mapper.map(property, PropertyDTO.class);
    }
}
