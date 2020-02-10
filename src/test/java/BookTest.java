import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookTest {
    @Test
    void shouldShowTheDetailsOfBook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        Book book = new Book("Book1", "Author1", 1999);

        book.print();

        verify(printStream).println("Book1\tAuthor1\t\t1999");

        printStream.close();
    }
}