package bookstore.controllers;

import bookstore.models.entities.Users;
import bookstore.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    public List<Users> index() {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Users get(@PathVariable Long id) {
        Optional<Users> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @PostMapping("/users")
    public Users create(@RequestBody Users user) {
        return this.userRepository.save(user);
    }
}
