package uz.spiders.propertymanagement.services;


import uz.spiders.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO create(PropertyDTO propertyDTO);
    PropertyDTO getById(Long id);
    PropertyDTO update(Long id, PropertyDTO propertyDTO);
    List<PropertyDTO> latestRented();
}
