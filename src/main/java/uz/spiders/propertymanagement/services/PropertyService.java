package uz.spiders.propertymanagement.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.spiders.propertymanagement.dto.AddressDTO;
import uz.spiders.propertymanagement.dto.PictureDTO;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.dto.PropertyPartialUpdateDTO;
import uz.spiders.propertymanagement.dto.requestDTO.GetOwnerPropertiesDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.entities.Property.ListingType;
import uz.spiders.propertymanagement.entities.Property.PropertyType;

import java.util.List;

public interface PropertyService {
    PropertyDTO create(PropertyDTO propertyDTO);
    PropertyDTO getById(Long id);
    PropertyDTO update(Long id, PropertyDTO propertyDTO);
    List<PropertyDTO> latestRented();

    //    Filtering optional location, rent/sale, price, home type, number of rooms
    public Page<Property> filter(Pageable page, AddressDTO address, ListingType listing,
                                 PropertyType type, Integer rooms, Double price);

    PropertyDTO partialUpdate(Long id, PropertyPartialUpdateDTO propertyDTO);

    PropertyDTO updateImages(Long id, List<PictureDTO> pictureDTOS);

    List<Property> findOwnerProperties(GetOwnerPropertiesDTO getOwnerPropertiesDTO);
}
