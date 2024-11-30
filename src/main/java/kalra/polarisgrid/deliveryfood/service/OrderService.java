package kalra.polarisgrid.deliveryfood.service;

import kalra.polarisgrid.deliveryfood.domain.Order;
import kalra.polarisgrid.deliveryfood.repository.OrderRepository;
import kalra.polarisgrid.deliveryfood.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RiderRepository riderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getCustomerOrderHistory(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> getRiderOrderHistory(Long riderId) {
        return orderRepository.findByRiderId(riderId);
    }

    public Order acceptOrReject(Long orderId, Boolean accepted) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("No Such order Exists by id: "+ orderId));
        order.setStatus("Accepted");// auto saved by in Transactional context
        return order;
    }

}
