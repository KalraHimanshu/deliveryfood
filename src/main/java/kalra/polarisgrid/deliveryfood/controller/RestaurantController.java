package kalra.polarisgrid.deliveryfood.controller;

import kalra.polarisgrid.deliveryfood.domain.FoodItem;
import kalra.polarisgrid.deliveryfood.domain.Restaurant;
import kalra.polarisgrid.deliveryfood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.registerRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<List<FoodItem>> getMenu(@PathVariable Long restaurantId) {
        return new ResponseEntity<>(restaurantService.getMenu(restaurantId), HttpStatus.OK);
    }

    @GetMapping("/suggest")
    public ResponseEntity<List<Restaurant>> suggestRestaurants(@RequestParam String cuisineType) {
        return new ResponseEntity<>(restaurantService.suggestRestaurants(cuisineType), HttpStatus.OK);
    }
}

