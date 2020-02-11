import Exceptions.InvalidOptionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class MenuTest {
    BookShelf bookShelf;
    Menu menu;

    ByteArrayInputStream byteArrayInputStream;
    PrintStream printStream;

    @BeforeEach
    void setup() {
        bookShelf = mock(BookShelf.class);
        menu = new Menu(bookShelf);

        printStream = mock(PrintStream.class);
        System.setOut(printStream);
    }

    @AfterEach
    void after() {
        printStream.close();
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void shouldShowAMenu() {
        menu.display();

        verify(printStream, times(1)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
    }

    @Test
    void shouldThrowAnExceptionWhenChosenAnInvalidOptionFromMenu() {
        byteArrayInputStream = new ByteArrayInputStream("8".getBytes());
        System.setIn(byteArrayInputStream);

        Assertions.assertThrows(InvalidOptionException.class, () -> menu.actions());
    }

    @Test
    void shouldQuitTheAppOnlyWhenQuitOptionIsChosen() throws InvalidOptionException {
        byteArrayInputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(byteArrayInputStream);

        menu.actions();

        verify(printStream, times(1)).println("Thank You!");
    }

}