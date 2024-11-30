package kalra.polarisgrid.deliveryfood.service;

import kalra.polarisgrid.deliveryfood.domain.Customer;
import kalra.polarisgrid.deliveryfood.domain.Rider;
import kalra.polarisgrid.deliveryfood.domain.User;
import kalra.polarisgrid.deliveryfood.repository.CustomerRepository;
import kalra.polarisgrid.deliveryfood.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RiderRepository riderRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Rider registerRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public Optional<? extends User> fetch(String email, Boolean isRider) {
        return isRider? riderRepository.findByEmail(email): customerRepository.findByEmail(email);
    }

    public void updateLocation(String email, int latitude, int longitude) {
        Rider rider = riderRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
        rider.setLatitude(latitude);
        rider.setLongitude(longitude);

    }

    // Method to find the nearest rider
    public Optional<Rider> findNearestAvailableRider(Integer latitude, Integer longitude) {
        // Get available riders sorted by distance to the given location
        List<Rider> riders = riderRepository.findAvailableRidersNearestToLocation(latitude, longitude);

        if (!riders.isEmpty()) {
            // Return the first rider (nearest one)
            return Optional.of(riders.get(0));
        }

        return Optional.empty();  // No available riders found
    }
}
