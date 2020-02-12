import Exceptions.MovieNotAvailableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MovieShelfTest {
    Stream stream;
    MovieShelf movieShelf;
    List<Movie> movies;

    @BeforeEach
    void setup() {
        stream = mock(Stream.class);
        movies = new ArrayList<>(Arrays.asList(
                new Movie("Movie1", 2019, "Director1", 9, stream),
                new Movie("Movie2", 2018, "Director2", 8, stream)));
        movieShelf = new MovieShelf(movies, stream);
    }

    @Test
    void shouldDisplayTheListOfMoviesWithDetails() {
        movieShelf.showMovies();

        verify(stream).write("Movie1\t2019\tDirector1\t9");
        verify(stream).write("Movie2\t2018\tDirector2\t8");
    }

    @Test
    void shouldCheckOutAMovie() throws MovieNotAvailableException {
        movieShelf.checkout(movies.get(0));

        Assertions.assertFalse(movies.contains(new Movie("Movie1", 2019, "Director1", 9, stream)));
    }

    @Test
    void shouldThrowAnExceptionWhenMovieIsUnAvailable() {
        Assertions.assertThrows(MovieNotAvailableException.class, () -> movieShelf.checkout(new Movie("Movie1", 2012, "Director1", 8, stream)));
    }
}