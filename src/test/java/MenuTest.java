import Exceptions.MovieNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class MenuTest {
    Stream stream;
    BookShelf bookShelf;
    MovieShelf movieShelf;
    Menu menu;
    MenuOption menuOption;

    @BeforeEach
    void setup() {
        stream = mock(Stream.class);
        bookShelf = mock(BookShelf.class);
        movieShelf = mock(MovieShelf.class);
        menu = new Menu(bookShelf, movieShelf, stream);
        menuOption = mock(MenuOption.class);
    }

    @Test
    void shouldShowAMenu() {
        menu.display();

        verify(stream).write("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(stream).write("Please select your choice...");
    }

    @Test
    void shouldDisplayAMessageWhenChosenAnInvalidOptionFromMenu() {
        when(stream.readInt()).thenReturn(8, 4);

        menu.actions();

        verify(stream, times(2)).write("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(stream, times(2)).write("Please select your choice...");
        verify(stream).write("Please select a valid option");
        verify(stream).write("Thank You.");
    }

    @Test
    void shouldQuitTheAppOnlyWhenQuitOptionIsChosen() {
        when(stream.readInt()).thenReturn(4);

        menu.actions();

        verify(stream).write("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(stream).write("Please select your choice...");
        verify(stream).write("Thank You.");
    }

    @Test
    void shouldShowAListOfMoviesIfSelectedFromMenu() {
        when(stream.readInt()).thenReturn(5, 4);

        menu.actions();

        verify(movieShelf).showMovies();
    }

    @Test
    void shouldCheckoutAMovieIfSelectedFromMenu() throws MovieNotAvailableException {
        when(stream.readInt()).thenReturn(6, 4);
        Movie movie = new Movie("Movie1", 2019, "Director1", 9, stream);
        when(stream.readMovie()).thenReturn(movie);

        menu.actions();

        verify(movieShelf).checkout(movie);
    }
}