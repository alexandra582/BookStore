package bookstore.controllers;

import bookstore.controllers.dtos.*;
import bookstore.models.entities.*;
import bookstore.models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.*;
import java.util.*;
import java.util.stream.*;

@CrossOrigin
@RestController
public class OrderController {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<OrderDto> index() {
        List<OrderDto> collect = orderRepository.findByUserId(1).stream().map(order ->
                new OrderDto(
                        order.getBooks().stream().mapToDouble(Book::getPrice).reduce(0, Double::sum),
                        order.getOrderDate() == null ? "Нет даты заказа" : dateFormat.format(order.getOrderDate())
                )
        ).collect(Collectors.toList());
        return collect;
    }


    @PostMapping("/orders/create")
    public Order create(@RequestBody List<Book> books) {
        Order order = new Order();
        order.setBooks(books);
        order.setOrderDate(new Date());
        order.setUserId(1);
        Order saved = orderRepository.save(order);
        return saved;
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
