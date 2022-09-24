package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.spiders.propertymanagement.dto.CreateFavouriteDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.entities.User;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.repos.UserRepository;
import uz.spiders.propertymanagement.services.FavouriteService;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class FavouriteServiceImpl implements FavouriteService {
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Transactional
    @Override
    public void create(CreateFavouriteDTO createFavouriteDTO) {
        User user = userRepository.findById(createFavouriteDTO.getUserId()).orElse(null);
        Property property = propertyRepository.findById(createFavouriteDTO.getPropertyId()).orElse(null);

        if (user == null || property == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The property or user not found");
        }

        user.getFavouriteProperties().add(property);
    };
}
