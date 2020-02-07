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
    void shouldShowTheListOfBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        List<String> expectedBookList = Arrays.asList("Book1", "Book2", "Book3");

        List<String> actualBookList = bibliotecaApp.getBooks();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }
}