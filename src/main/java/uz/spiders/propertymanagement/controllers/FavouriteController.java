package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.CreateFavouriteDTO;
import uz.spiders.propertymanagement.services.FavouriteService;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/favourites")
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping
    public void createFavourite(@Valid @RequestBody CreateFavouriteDTO createFavouriteDTO) {
        favouriteService.create(createFavouriteDTO);
    }
}
