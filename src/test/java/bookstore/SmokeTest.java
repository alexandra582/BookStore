package bookstore;

import bookstore.controllers.BookController;
import bookstore.controllers.GenreController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class SmokeTest {

    @Autowired
    BookController bookController;

    @Autowired
    GenreController genreController;

    @Test
    public void bookControllerLoaded() {
        assertThat(bookController).isNotNull();
    }

    @Test
    public void genreControllerLoaded() {
        assertThat(genreController).isNotNull();
    }
}
