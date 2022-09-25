package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.entities.Application;
import uz.spiders.propertymanagement.services.ApplicationService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/properties/{id}/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping(path = "")
    public Application create(@PathVariable Long id){
//        TODO: fetch current authenticated user from security context and pass it to the method
        return applicationService.create(id, 1l);
    }
}
