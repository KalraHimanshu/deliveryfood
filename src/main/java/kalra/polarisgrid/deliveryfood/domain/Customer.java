package kalra.polarisgrid.deliveryfood.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class Customer extends User {

    private String email;
    private Double customerRating;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
