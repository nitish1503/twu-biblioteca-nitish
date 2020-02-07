import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        List<Book> expectedBookList = Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990));

        List<Book> actualBookList = bibliotecaApp.getBooks();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }
}