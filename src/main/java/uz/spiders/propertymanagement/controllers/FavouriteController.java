package uz.spiders.propertymanagement.controllers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.services.FavouriteService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/favourites")
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping("/user/{userId}/property/{propertyId}")
    public void createFavourite(@PathVariable Long userId, @PathVariable Long propertyId) {
        favouriteService.create(userId, propertyId);
    }

    @GetMapping("/user/{userId}")
    public List<PropertyDTO> findAll(@PathVariable Long userId) {
        return favouriteService.findAll(userId);
    }

    @DeleteMapping("/user/{userId}/property/{propertyId}")
    public void delete(@PathVariable Long userId, @PathVariable Long propertyId) {
        favouriteService.delete(userId, propertyId);
    }
}
