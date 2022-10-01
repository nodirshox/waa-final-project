package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.PropertyDTO;
import uz.spiders.propertymanagement.dto.requestDTO.CreateFavouriteDTO;
import uz.spiders.propertymanagement.dto.requestDTO.DeleteFavouriteDTO;
import uz.spiders.propertymanagement.services.FavouriteService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/favourites")
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping("/property/{propertyId}")
    public void createFavourite(@RequestBody CreateFavouriteDTO createFavouriteDTO, @PathVariable Long propertyId) {
        favouriteService.create(createFavouriteDTO, propertyId);
    }

    @GetMapping
    public List<PropertyDTO> findAll(@RequestParam String email) {
        return favouriteService.findAll(email);
    }

    @PostMapping("/property/{propertyId}/remove")
    public void delete(@RequestBody DeleteFavouriteDTO deleteFavouriteDTO, @PathVariable Long propertyId) {
        favouriteService.delete(deleteFavouriteDTO, propertyId);
    }
}
