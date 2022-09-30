package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.UserDTO;
import uz.spiders.propertymanagement.entities.User;
import uz.spiders.propertymanagement.services.UserService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @GetMapping(path = "")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/latest-customers")
    public List<UserDTO> latestCustomers() {
        return userService.latestCustomers();
    }

    @GetMapping(path = "/email")
    public List<User> getAll(@Valid @RequestParam String email) {
        return userService.getAllByEmail(email);
    }
}
