package kalra.polarisgrid.deliveryfood.service;

import kalra.polarisgrid.deliveryfood.domain.FoodItem;
import kalra.polarisgrid.deliveryfood.domain.Restaurant;
import kalra.polarisgrid.deliveryfood.repository.FoodItemRepository;
import kalra.polarisgrid.deliveryfood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<FoodItem> getMenu(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }

    public List<Restaurant> suggestRestaurants(String cuisineType) {
        return restaurantRepository.findByCuisineType(cuisineType);
    }
}

