package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavouriteDTO {
    @NotNull(message = "The userId is required")
    private Long userId;

    @NotNull(message = "The propertyId is required")
    private Long propertyId;
}
