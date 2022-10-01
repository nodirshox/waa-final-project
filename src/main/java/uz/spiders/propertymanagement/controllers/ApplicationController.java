package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.requestDTO.CreateApplicationDTO;
import uz.spiders.propertymanagement.dto.requestDTO.GetApplicationsDTO;
import uz.spiders.propertymanagement.entities.Application;
import uz.spiders.propertymanagement.services.ApplicationService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/properties/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping(path = "/{id}")
    public Application create(@PathVariable Long id, @RequestBody CreateApplicationDTO createApplicationDTO){
//        TODO: fetch current authenticated user from security context and pass it to the method
        return applicationService.create(id, createApplicationDTO);
    }

    @PostMapping
    public List<Application> findAll(@RequestBody GetApplicationsDTO getApplicationsDTO) {
        return applicationService.findAll(getApplicationsDTO);
    }
}
