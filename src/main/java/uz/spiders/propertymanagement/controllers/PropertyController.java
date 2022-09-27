package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.AddressDTO;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.dto.PropertyPartialUpdateDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.entities.Property.ListingType;
import uz.spiders.propertymanagement.entities.Property.PropertyType;
import uz.spiders.propertymanagement.services.PropertyService;
import javax.annotation.security.RolesAllowed;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/properties")
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping("")
    public Page<Property> getAll(Pageable page, @RequestParam(required = false) String state, @RequestParam(required = false) String city,
                                 @RequestParam(required = false) String street, @RequestParam(required = false) String zip,
                                 @RequestParam(required = false) Double price, @RequestParam(name = "numberOfRooms", required = false) Integer rooms,
                                 @RequestParam(name = "listingType", required = false) ListingType listing, @RequestParam(required = false) PropertyType type) {
        AddressDTO address = new AddressDTO(null, state, city, street, zip);
        return propertyService.filter(page, address, listing, type, rooms, price);
    }

    @PostMapping
    public PropertyDTO create(@Valid @RequestBody PropertyDTO propertyDTO) {
        return propertyService.create(propertyDTO);
    }

    @GetMapping("/{id}")
    public PropertyDTO getById(@PathVariable Long id) {
        return propertyService.getById(id);
    }

    @PutMapping("/{id}")
    public PropertyDTO update(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        return propertyService.update(id, propertyDTO);
    }

    @PatchMapping("/{id}")
    public PropertyDTO partialUpdate(@PathVariable Long id, @RequestBody PropertyPartialUpdateDTO propertyDTO) {
        return propertyService.partialUpdate(id, propertyDTO);
    }

    @GetMapping("/latest-rented")
    @RolesAllowed({ "customer" })
    public List<PropertyDTO> latestRented() {
        return propertyService.latestRented();
    }
}
