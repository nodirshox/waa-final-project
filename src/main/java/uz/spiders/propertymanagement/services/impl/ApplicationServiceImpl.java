package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.spiders.propertymanagement.entities.Application;
import uz.spiders.propertymanagement.exceptions.ServerException;
import uz.spiders.propertymanagement.messaging.EmailEventProducer;
import uz.spiders.propertymanagement.repos.ApplicationRepository;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.repos.UserRepository;
import uz.spiders.propertymanagement.services.ApplicationService;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final PropertyRepository propertyRepository;
    private final EmailEventProducer producer;

    @Override
    public Application create(Long propertyId, Long userId) {
        var property = propertyRepository.findById(propertyId);
        var user = userRepository.findById(userId);
        if(user.isPresent() && property.isPresent()){
            Application application = new Application(property.get(), user.get());
//            String ownerEmail = property.get().getOwner().getEmail();
//            TODO: Uncomment and pass owner email as argument once security is implemented
            producer.send();
            return applicationRepository.save(application);
        }else{
            throw new ServerException("Unknown Error while handling application creation");
        }
    }
}
