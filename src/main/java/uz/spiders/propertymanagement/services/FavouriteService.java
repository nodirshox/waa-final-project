package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface FavouriteService {
    void create(Long userId, Long propertyId);
    List<PropertyDTO> findAll(Long userId);

    void delete(Long userId, Long propertyId);
}
