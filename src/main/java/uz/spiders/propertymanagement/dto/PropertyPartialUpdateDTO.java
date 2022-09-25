package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.spiders.propertymanagement.entities.Property;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPartialUpdateDTO {
    private Double price;
    private Integer numberOfRooms;
    private Property.ListingType listingType;
    private Property.PropertyStatus status;
    private Property.PropertyType type;
}
