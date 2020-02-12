import Exceptions.MovieNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class MenuTest {
    Stream stream;
    BookShelf bookShelf;
    MovieShelf movieShelf;
    BibliotecaApp bibliotecaApp;
    Menu menu;
    MenuOption menuOption;

    @BeforeEach
    void setup() {
        stream = mock(Stream.class);
        bookShelf = mock(BookShelf.class);
        movieShelf = mock(MovieShelf.class);
        bibliotecaApp = mock(BibliotecaApp.class);
        menu = new Menu(bibliotecaApp, bookShelf, movieShelf, stream);
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
    void shouldCheckoutAMovieIfSelectedFromMenu() {
        when(stream.readInt()).thenReturn(6, 4);
        Movie movie = new Movie("Movie1", 2019, "Director1", 9, stream);
        when(stream.readMovie()).thenReturn(movie);

        menu.actions();

        verify(stream, times(2)).write("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(stream, times(2)).write("Please select your choice...");
        verify(stream).write("Thank You! Enjoy the movie");
        verify(stream).write("Thank You.");
    }

    @Test
    void shouldShowAMessageIfMovieIsNotAvailableForCheckout() throws MovieNotAvailableException {
        when(stream.readInt()).thenReturn(6, 4);
        Movie movie = new Movie("Movie3", 2020, "Director3", 9, stream);
        when(stream.readMovie()).thenReturn(movie);
        doThrow(MovieNotAvailableException.class).when(movieShelf).checkout(movie);

        menu.actions();

        verify(stream, times(2)).write("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(stream, times(2)).write("Please select your choice...");
        verify(stream).write("Sorry! that movie is not available for checkout");
        verify(stream).write("Thank You.");
    }

    @Test
    void shouldLoginAUser() {
        when(stream.readInt()).thenReturn(7, 4);
        User user = new User("ABC-1234", "password");
        when(stream.readUser()).thenReturn(user);

        menu.actions();

        verify(bibliotecaApp).login(user);
    }
}