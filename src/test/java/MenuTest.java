import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    void shouldShowAMenu() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);
        Menu menu = new Menu(bookShelf);

        menu.display();

        verify(printStream, times(1)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
    }

    @Test
    void shouldShowAListOfBooksWhenChosenFromMenu() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);
        Menu menu = new Menu(bookShelf);

        menu.actions();

        verify(printStream, times(2)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    @Test
    void shouldNotifyWhenChosenAnInvalidOptionFromMenu() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("8\n4".getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);
        Menu menu = new Menu(bookShelf);

        menu.actions();

        verify(printStream, times(2)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        verify(printStream).println("Please select a valid option!");
    }

    @Test
    void shouldQuitTheAppOnlyWhenQuitOptionIsChosen() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "1\n4";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);
        Menu menu = new Menu(bookShelf);

        menu.actions();

        verify(printStream, times(2)).println("1. List of books\n2. Checkout\n3. Return\n4. Quit");
        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

}