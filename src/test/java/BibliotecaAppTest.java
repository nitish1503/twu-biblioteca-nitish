import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class BibliotecaAppTest {

    @Test
    void shouldShowAWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualMessage = bibliotecaApp.welcome();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldBeAbleToShowTheListOfBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<String> expectedBookList = new ArrayList<>(Arrays.asList("Book1", "Book2", "Book3"));

        ArrayList<String> actualBookList = bibliotecaApp.showBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }
}