package uz.spiders.propertymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.PropertyDto;
import uz.spiders.propertymanagement.services.PropertyService;

@RestController
@CrossOrigin
@RequestMapping("/api/properties")
public class PropertyController {
    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public void create(@RequestBody PropertyDto propertyDTO) {
        propertyService.create(propertyDTO);
    }

}
