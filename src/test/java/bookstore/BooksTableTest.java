package bookstore;

import bookstore.models.entities.Book;
import bookstore.models.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BooksTableTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void isEmpty() {
        Iterable<Book> books = bookRepository.findAll();

        assertThat(books).isEmpty();
    }
}
