import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    void shouldShowAWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualMessage = bibliotecaApp.welcome();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldShowTheListOfBooksWithAuthorAndYearOfPublication() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        List<Book> books = Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990));

        bibliotecaApp.showBooks();

        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    @Test
    void shouldShowAMenu() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.menu();

        verify(printStream, times(1)).println("1. List of books\n4. Quit");
    }

    @Test
    void shouldShowAListOfBooksWhenChosenFromMenu() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("1\n4".getBytes()));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        List<Book> books = Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990));

        bibliotecaApp.menu();

        verify(printStream, times(2)).println("1. List of books\n4. Quit");
        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    @Test
    void shouldNotifyWhenChosenAnInvalidOptionFromMenu() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream("2\n4".getBytes()));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.menu();

        verify(printStream, times(2)).println("1. List of books\n4. Quit");
        verify(printStream).println("Please select a valid option!");
    }

    @Test
    void shouldQuitTheAppOnlyWhenQuitOptionIsChosen() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "1\n4";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        List<Book> books = Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990));

        bibliotecaApp.menu();

        verify(printStream, times(2)).println("1. List of books\n4. Quit");
        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }
}