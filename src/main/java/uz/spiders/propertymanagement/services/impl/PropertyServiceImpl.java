package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.services.PropertyService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

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
}
