package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.PropertyDTO;
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

    @GetMapping("/latest-rented")
    public List<PropertyDTO> latestRented() {
        return propertyService.latestRented();
    }

}
