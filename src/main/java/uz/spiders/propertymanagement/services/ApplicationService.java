package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.requestDTO.CreateApplicationDTO;
import uz.spiders.propertymanagement.dto.requestDTO.GetApplicationsDTO;
import uz.spiders.propertymanagement.entities.Application;

import java.util.List;

public interface ApplicationService {

    public Application create(Long propertyId, CreateApplicationDTO createApplicationDTO);
    List<Application> findAll(GetApplicationsDTO getApplicationsDTO);
}
