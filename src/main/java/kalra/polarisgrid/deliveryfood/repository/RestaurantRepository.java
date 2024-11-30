package kalra.polarisgrid.deliveryfood.repository;

import kalra.polarisgrid.deliveryfood.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCuisineType(String cuisineType);
}

