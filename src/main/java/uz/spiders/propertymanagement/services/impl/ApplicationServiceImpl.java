package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.spiders.propertymanagement.dto.requestDTO.CreateApplicationDTO;
import uz.spiders.propertymanagement.dto.requestDTO.GetApplicationsDTO;
import uz.spiders.propertymanagement.entities.Application;
import uz.spiders.propertymanagement.entities.User;
import uz.spiders.propertymanagement.exceptions.ServerException;
import uz.spiders.propertymanagement.messaging.EmailEventProducer;
import uz.spiders.propertymanagement.repos.ApplicationRepository;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.repos.UserRepository;
import uz.spiders.propertymanagement.services.ApplicationService;

import java.util.List;
import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final PropertyRepository propertyRepository;
    private final EmailEventProducer producer;

    @Override
    public Application create(Long propertyId, CreateApplicationDTO createApplicationDTO) {
        var property = propertyRepository.findById(propertyId);
        var user = userRepository.getByEmail(createApplicationDTO.getEmail());
        if(user != null && property.isPresent()){
            Application application = new Application(property.get(), user);
//            String ownerEmail = property.get().getOwner().getEmail();
//            TODO: Uncomment and pass owner email as argument once security is implemented
            producer.send();
            return applicationRepository.save(application);
        }else{
            throw new ServerException("Unknown Error while handling application creation");
        }
    }

    @Override
    public List<Application> findAll(GetApplicationsDTO getApplicationsDTO) {
        User user = userRepository.getByEmail(getApplicationsDTO.getEmail());

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found");
        }
        List<Application> applications = applicationRepository.findAll();
        List<Application> filtered = new ArrayList<>();
        for (Application application:applications) {
            if (user.getProperties().contains(application.getProperty())) {
                filtered.add(application);
            }

        }

        return filtered;
    }
}
