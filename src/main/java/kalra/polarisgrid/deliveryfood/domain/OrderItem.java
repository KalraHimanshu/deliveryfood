package kalra.polarisgrid.deliveryfood.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem extends BaseJPAEntity {

    private Integer quantity;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "foodItem_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
