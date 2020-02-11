import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

class BookTest {
    @Test
    void shouldShowTheDetailsOfBook() {
        Stream stream = mock(Stream.class);
        Book book = new Book("Book1", "Author1", 1999, stream);

        book.print();

        verify(stream).write("Book1\tAuthor1\t\t1999");
    }
}