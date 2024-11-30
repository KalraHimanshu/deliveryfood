//package kalra.polarisgrid.delieveryfood.domain;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//public class Menu {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToMany(mappedBy = "restaurant")
//    private List<FoodItem> menuItems;  // A Menu has many MenuItems
//
//    @ManyToOne
//    private Restaurant restaurant;
//
//    // Getters and Setters
//}
