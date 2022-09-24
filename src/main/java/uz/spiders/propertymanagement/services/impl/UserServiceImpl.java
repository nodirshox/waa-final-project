package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.spiders.propertymanagement.dto.UserDTO;
import uz.spiders.propertymanagement.entities.User;
import uz.spiders.propertymanagement.repos.UserRepository;
import uz.spiders.propertymanagement.services.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO create(UserDTO userDTO) {
        userDTO.setCreatedAt(LocalDateTime.now());
        userDTO.setType(User.UserType.CUSTOMER);
        var user = mapper.map(userDTO, User.class);
        User created = userRepository.save(user);

        return mapper.map(created, UserDTO.class);
    }

    @Override
    public List<UserDTO> latestCustomers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findTop10ByTypeOrderByCreatedAtDesc(User.UserType.CUSTOMER);

        for (User user: users) {
            userDTOS.add(mapper.map(user, UserDTO.class));
        }

        return userDTOS;
    }
}
