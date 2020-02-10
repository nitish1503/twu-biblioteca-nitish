import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    void afterEach() throws IOException {
        byteArrayInputStream.close();
        printStream.close();
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void shouldShowAMenu() {
        byteArrayInputStream = new ByteArrayInputStream("4".getBytes());
        System.setIn(byteArrayInputStream);

        menu.display();

        verify(printStream, times(1)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
    }

    @Test
    void shouldShowAListOfBooksWhenChosenFromMenu() {
        byteArrayInputStream = new ByteArrayInputStream("1\n4".getBytes());
        System.setIn(byteArrayInputStream);

        menu.actions();

        verify(bookShelf, times(1)).showBooks();
    }

    @Test
    void shouldDisplayAMessageWhenChosenAnInvalidOptionFromMenu() {
        byteArrayInputStream = new ByteArrayInputStream("8\n4".getBytes());
        System.setIn(byteArrayInputStream);

        menu.actions();

        verify(printStream, times(2)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(printStream).println("Please select a valid option!");
    }

    @Test
    void shouldQuitTheAppOnlyWhenQuitOptionIsChosen() {
        byteArrayInputStream = new ByteArrayInputStream("1\n4".getBytes());
        System.setIn(byteArrayInputStream);

        menu.actions();

        verify(printStream, times(1)).println("Thank You!");
    }

}