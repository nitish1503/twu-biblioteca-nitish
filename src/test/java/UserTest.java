import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserTest {

    @Test
    void shouldShowUserDetails() {
        Stream stream = mock(Stream.class);
        User user = new User("ABC-1234", "password", stream);

        user.show();

        verify(stream).write("Library Id: ABC-1234");
    }
}