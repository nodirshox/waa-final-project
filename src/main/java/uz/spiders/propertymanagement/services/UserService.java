package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> latestCustomers();
}
