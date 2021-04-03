package bookstore;

import bookstore.models.entities.Users;
import bookstore.models.repositories.UserRepository;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldReturnAll() throws Exception {
        List<Users> users = userRepository.findAll();
        String usersJson = new Gson().toJson(users);

        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(usersJson));
    }

    @Test
    public void shouldReturnById() throws Exception {
        Users user = this.userRepository.save(new Users(1L, "TestUser"));
        String usersJson = new Gson().toJson(user);

        mockMvc.perform(get("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(usersJson));
    }

    @Test
    public void shouldCreateNewRecord() throws Exception {

        String userJson = new Gson().toJson(new Users("New Yser"));

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(userJson))
                .andExpect(status().is2xxSuccessful());

        Optional<Users> createdUser = this.userRepository.findByName("New Yser");
        assertThat(createdUser.get()).isNotNull();
        assertThat(createdUser.get()).hasFieldOrPropertyWithValue("name", "New Yser");

    }
}
