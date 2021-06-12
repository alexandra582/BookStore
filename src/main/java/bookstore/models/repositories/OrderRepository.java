package bookstore.models.repositories;

import bookstore.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Integer userId);

}
