package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.services.PropertyService;

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
    public List<PropertyDTO> latestRented() {
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        List<Property> properties = propertyRepository.findTop10ByStatusOrderByCreatedAtDesc(Property.PropertyStatus.RENTED);

        for (Property property: properties) {
            propertyDTOS.add(mapper.map(property, PropertyDTO.class));
        }

        return propertyDTOS;
    }
}
