import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MovieShelfTest {
    @Test
    void shouldDisplayTheListOfMoviesWithDetails() {
        Stream stream = mock(Stream.class);
        List<Movie> movies = new ArrayList<>(Arrays.asList(new Movie("Movie1", 2019, "Director1", 9, stream), new Movie("Movie2", 2018, "Director2", 8, stream)));
        MovieShelf movieShelf = new MovieShelf(movies, stream);

        movieShelf.showMovies();

        verify(stream).write("Movie1\t2019\tDirector1\t9");
        verify(stream).write("Movie2\t2018\tDirector2\t8");
    }
}