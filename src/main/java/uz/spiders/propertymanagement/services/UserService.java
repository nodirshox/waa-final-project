package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.UserDTO;
import uz.spiders.propertymanagement.entities.User;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO userDTO);
    List<UserDTO> latestCustomers();

    List<User> getAll();
    List<User> getAllByEmail(String email);
}
