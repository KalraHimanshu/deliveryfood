package kalra.polarisgrid.deliveryfood.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends BaseJPAEntity{

    private String name;
    private String address;
    private String cuisineType;

//    @OneToMany(mappedBy = "restaurant")
//    private List<Menu> menu;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;
}

