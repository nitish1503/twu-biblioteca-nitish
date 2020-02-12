import Exceptions.ApplicationClosedException;
import Exceptions.InvalidOptionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {
    Stream stream;
    BookShelf bookShelf;
    Menu menu;

    @BeforeEach
    void setup() {
        stream = mock(Stream.class);
        bookShelf = mock(BookShelf.class);
        menu = new Menu(bookShelf, stream);
    }

    @Test
    void shouldShowAMenu() {
        menu.display();

        verify(stream).write("1. List of books\n2. Checkout\n3. Return\n4. Quit");
    }

    @Test
    void shouldThrowAnExceptionWhenChosenAnInvalidOptionFromMenu() {
        when(stream.readInt()).thenReturn(8);

        Assertions.assertThrows(InvalidOptionException.class, () -> menu.actions());
    }

    @Test
    void shouldQuitTheAppOnlyWhenQuitOptionIsChosen() {
        when(stream.readInt()).thenReturn(4);

        Assertions.assertThrows(ApplicationClosedException.class, () -> menu.actions());
    }

}