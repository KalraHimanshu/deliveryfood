package kalra.polarisgrid.deliveryfood.repository;

import kalra.polarisgrid.deliveryfood.domain.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByRestaurantId(Long restaurantId);  // Retrieve menu for a restaurant
}

