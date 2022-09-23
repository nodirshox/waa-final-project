package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.spiders.propertymanagement.entities.Property;

import javax.persistence.Enumerated;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private double price;
    private int numberOfRooms;

    @Enumerated
    private Property.ListingType listingType;

    @Enumerated
    private Property.PropertyType type;

    private AddressDTO address;
}
