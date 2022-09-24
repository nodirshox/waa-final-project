package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO userDTO);
    List<UserDTO> latestCustomers();
}
