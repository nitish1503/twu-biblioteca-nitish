import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}