package uz.spiders.propertymanagement.services;


import uz.spiders.propertymanagement.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto create(PropertyDto propertyDTO);
    List<PropertyDto> latestRented();
}
