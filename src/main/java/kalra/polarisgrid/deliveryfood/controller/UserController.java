package kalra.polarisgrid.deliveryfood.controller;

import kalra.polarisgrid.deliveryfood.domain.Customer;
import kalra.polarisgrid.deliveryfood.domain.Rider;
import kalra.polarisgrid.deliveryfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/customer")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(userService.registerCustomer(customer), HttpStatus.CREATED);
    }

    @PostMapping("/rider")
    public ResponseEntity<Rider> registerRider(@RequestBody Rider rider) {
        return new ResponseEntity<>(userService.registerRider(rider), HttpStatus.CREATED);
    }
}
