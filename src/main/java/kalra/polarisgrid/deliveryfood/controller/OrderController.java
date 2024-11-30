package kalra.polarisgrid.deliveryfood.controller;

import kalra.polarisgrid.deliveryfood.domain.Order;
import kalra.polarisgrid.deliveryfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("{orderId}/action")
    public ResponseEntity<Order> acceptOrRejectOrder(@PathVariable("orderId") Long orderId, @RequestParam("accepted") Boolean accepted) {
        return new ResponseEntity<>(orderService.acceptOrReject(orderId, accepted), HttpStatus.CREATED);
    }

    @GetMapping("/history/customer/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrderHistory(@PathVariable Long customerId) {
        return new ResponseEntity<>(orderService.getCustomerOrderHistory(customerId), HttpStatus.OK);
    }

    @GetMapping("/history/rider/{riderId}")
    public ResponseEntity<List<Order>> getRiderOrderHistory(@PathVariable Long riderId) {
        return new ResponseEntity<>(orderService.getRiderOrderHistory(riderId), HttpStatus.OK);
    }
}

