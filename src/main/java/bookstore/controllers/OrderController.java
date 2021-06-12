package bookstore.controllers;

import bookstore.models.entities.Order;
import bookstore.models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> index() {
        return (List<Order>) orderRepository.findAll();
    }

    @PostMapping("/orders/create")
    public Order create(@RequestBody Order order) {
        return orderRepository.save(order);
    }


    @GetMapping("/orders/{id}")
    public Order get(@PathVariable long id) {
        Optional<Order> result = orderRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
}
