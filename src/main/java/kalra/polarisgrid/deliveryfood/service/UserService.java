package kalra.polarisgrid.deliveryfood.service;

import kalra.polarisgrid.deliveryfood.domain.Customer;
import kalra.polarisgrid.deliveryfood.domain.Rider;
import kalra.polarisgrid.deliveryfood.repository.CustomerRepository;
import kalra.polarisgrid.deliveryfood.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
