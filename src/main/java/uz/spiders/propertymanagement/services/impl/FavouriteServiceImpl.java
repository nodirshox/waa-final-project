package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.dto.requestDTO.CreateFavouriteDTO;
import uz.spiders.propertymanagement.dto.requestDTO.DeleteFavouriteDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.entities.User;
import uz.spiders.propertymanagement.repos.PropertyRepository;
import uz.spiders.propertymanagement.repos.UserRepository;
import uz.spiders.propertymanagement.services.FavouriteService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class FavouriteServiceImpl implements FavouriteService {
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Transactional
    @Override
    public void create(CreateFavouriteDTO createFavouriteDTO, Long propertyId) {
        User existingUser = userRepository.getByEmail(createFavouriteDTO.getEmail());

        Property property = propertyRepository.findById(propertyId).orElse(null);

        if (existingUser == null || property == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The property or user not found");
        }

        if (existingUser.getType() != User.UserType.CUSTOMER) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only CUSTOMER can create favourite property");
        }

        if (existingUser.getFavouriteProperties().contains(property)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The property is already in favourite list of user");
        }

        existingUser.getFavouriteProperties().add(property);
    };

    @Override
    public List<PropertyDTO> findAll(String email) {
        User user = userRepository.getByEmail(email);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user not found");
        }

        List<PropertyDTO> propertyDTOS = new ArrayList<>();

        for (Property property: user.getFavouriteProperties()) {
            propertyDTOS.add(mapper.map(property, PropertyDTO.class));
        }

        return propertyDTOS;
    }

    @Override
    @Transactional
    public void delete(DeleteFavouriteDTO deleteFavouriteDTO, Long propertyId) {
        User user = userRepository.getByEmail(deleteFavouriteDTO.getEmail());
        Property property = propertyRepository.findById(propertyId).orElse(null);

        if (user == null || property == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The property or user not found");
        }

        if (!user.getFavouriteProperties().contains(property)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The property is not favourite list of user");
        }

        user.getFavouriteProperties().remove(property);
    }
}
