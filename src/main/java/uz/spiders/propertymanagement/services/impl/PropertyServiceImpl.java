package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.spiders.propertymanagement.dto.PropertyDto;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.services.PropertyService;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final ModelMapper mapper;

    @Override
    public PropertyDto create(PropertyDto propertyDTO) {
        propertyDTO.setCreatedAt(LocalDateTime.now());
        propertyDTO.setStatus(Property.PropertyStatus.OPEN);
        var property = mapper.map(propertyDTO, Property.class);
        Property created = propertyRepository.save(property);
        var newProperty = mapper.map(created, PropertyDto.class);
        return newProperty;
    };
}
