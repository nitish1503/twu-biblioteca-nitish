import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void shouldShowCurrentLoggedInUserDetails() {
        Stream stream = mock(Stream.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.login(new User("ABC-1234", "password", stream));

        bibliotecaApp.showCurrentUser();

        verify(stream).write("Library Id: ABC-1234");
    }
}