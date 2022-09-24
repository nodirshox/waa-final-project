package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.entities.Application;

public interface ApplicationService {

    public Application create(Long propertyId, Long userId);
}
