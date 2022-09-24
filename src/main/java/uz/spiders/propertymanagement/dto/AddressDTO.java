package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;

    @NotEmpty(message = "The state is required")
    @Size(min = 2, max = 2, message = "The state size is 2")
    private String state;

    @NotEmpty(message = "The city is required")
    private String city;

    @NotEmpty(message = "The street is required")
    private String street;

    @NotEmpty(message = "The zip is required")
    private String zip;
}
