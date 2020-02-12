import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MovieTest {

    @Test
    void shouldShowMovieDetails() {
        Stream stream = mock(Stream.class);
        Movie movie = new Movie("Avengers: End Game", 2019, "Russo Brothers", 9, stream);
        movie.print();

        verify(stream).write("Avengers: End Game\t2019\tRusso Brothers\t9");
    }
}