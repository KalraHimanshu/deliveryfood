package kalra.polarisgrid.deliveryfood.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rider")
public class Rider extends User{

    private String email;
    private String vehicleDetails;
    private Integer latitude; // Could be a GPS coordinate or address
    private Integer longitude;

    private Double rating;  // For bonus requirement

    @OneToMany(mappedBy = "rider")// todo
    private List<Order> orders;
}

