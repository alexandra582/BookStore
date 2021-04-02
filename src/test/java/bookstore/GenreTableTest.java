package bookstore;

import bookstore.models.entities.Genre;
import bookstore.models.repositories.GenreRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreTableTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    GenreRepository genreRepository;

    @Test
    public void shouldFindAllGenres() {
        Iterable<Genre> genres = genreRepository.findAll();

        assertThat(genres).isNotEmpty();
    }

    @Test
    public void shouldInsertGenres() {

        Genre savedGenre = this.genreRepository.save(new Genre("Test genre"));

        assertThat(savedGenre).hasFieldOrPropertyWithValue("name", "Test genre");
    }

    @Test void shouldFindById() {
        Genre savedGenre = this.genreRepository.save(new Genre("Test genre"));
        Optional<Genre> foundGenre = this.genreRepository.findById(savedGenre.getId());

        assertThat(foundGenre.get()).isNotNull();
        assertThat(foundGenre.get()).hasFieldOrPropertyWithValue("name", "Test genre");

    }

}
