package kalra.polarisgrid.deliveryfood.controller;

import kalra.polarisgrid.deliveryfood.domain.Customer;
import kalra.polarisgrid.deliveryfood.domain.Rider;
import kalra.polarisgrid.deliveryfood.domain.User;
import kalra.polarisgrid.deliveryfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    @GetMapping("/customer/{email}")
    public ResponseEntity<? extends User> getCustomer(@PathVariable("email") String email, @RequestParam(value = "isRider") boolean isRider) {
        return new ResponseEntity<>(userService.fetch(email, isRider).orElseThrow(()-> new NoSuchElementException("No such User exists")), HttpStatus.OK);
    }

    @PutMapping("/rider/{email}/location")
    public ResponseEntity<Boolean> updateRiderLocation(@PathVariable("email") String email,
                                                              @RequestParam(value = "latitude") int latitude,
                                                              @RequestParam(value = "longitude") int longitude) {
        userService.updateLocation(email, latitude, longitude);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PutMapping("/rider/{email}/location")
    public ResponseEntity<Optional<Rider>> findRiderLocation(@RequestParam(value = "latitude") int latitude,
                                                      @RequestParam(value = "longitude") int longitude) {
        ;
        return new ResponseEntity<>(userService.findNearestAvailableRider(latitude, longitude), HttpStatus.OK);
    }

}
