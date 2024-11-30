package kalra.polarisgrid.deliveryfood.repository;

import kalra.polarisgrid.deliveryfood.domain.Customer;
import kalra.polarisgrid.deliveryfood.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Rider> findByEmail(String email);
}
