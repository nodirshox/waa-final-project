package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.dto.requestDTO.CreateFavouriteDTO;
import uz.spiders.propertymanagement.dto.requestDTO.DeleteFavouriteDTO;

import java.util.List;

public interface FavouriteService {
    void create(CreateFavouriteDTO createFavouriteDTO, Long propertyId);
    List<PropertyDTO> findAll(String email);

    void delete(DeleteFavouriteDTO deleteFavouriteDTO, Long propertyId);
}
