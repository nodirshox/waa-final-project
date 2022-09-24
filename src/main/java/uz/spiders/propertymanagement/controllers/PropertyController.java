package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.PropertyDto;
import uz.spiders.propertymanagement.services.PropertyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/properties")
public class PropertyController {
    private final PropertyService propertyService;

    @PostMapping
    public PropertyDto create(@Valid @RequestBody PropertyDto propertyDTO) {
        return propertyService.create(propertyDTO);
    }

    @GetMapping("/rented")
    public List<PropertyDto> latestRented() {
        return propertyService.latestRented();
    }

}
