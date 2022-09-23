package uz.spiders.propertymanagement.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.spiders.propertymanagement.dto.PropertyDto;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.services.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private ModelMapper mapper;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, ModelMapper mapper) {
        this.propertyRepository = propertyRepository;
        this.mapper = mapper;
    }

    @Override
    public void create(PropertyDto propertyDTO) {
        var property = mapper.map(propertyDTO, Property.class);
        propertyRepository.save(property);
    };
}
