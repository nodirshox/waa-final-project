package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.spiders.propertymanagement.entities.Picture;
import uz.spiders.propertymanagement.entities.Property;

import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long id;

    @DecimalMin(value = "0.01", message = "The minimum price is 0.01")
    @NotNull(message = "The price is required")
    private Double price;

    @NotNull(message = "The numberOfRooms is required")
    @Min(value = 1, message = "Min numberOfRooms is 1")
    private Integer numberOfRooms;

    @Enumerated
    private Property.ListingType listingType;

    @Enumerated
    private Property.PropertyStatus status;

    @Enumerated
    private Property.PropertyType type;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<PictureDTO> pictures;

    @Valid
    private AddressDTO address;
}
