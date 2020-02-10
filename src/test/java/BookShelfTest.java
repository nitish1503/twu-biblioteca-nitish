import Exceptions.BookNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookShelfTest {

    BookShelf bookShelf;
    List<Book> books;

    @BeforeEach
    void setup() {
        books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        bookShelf = new BookShelf(books);
    }

    @Test
    void shouldShowTheListOfBooksWithAuthorAndYearOfPublication() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        bookShelf.showBooks();

        verify(printStream, times(1)).println("Book1\tAuthor1\t\t1999");
        verify(printStream, times(1)).println("Book2\tAuthor2\t\t1990");
    }

    @Test
    void shouldCheckoutABook() throws BookNotFoundException {
        bookShelf.checkout(books.get(0));

        Assertions.assertFalse(books.contains(new Book("Book1", "Author1", 1999)));
    }

    @Test
    void shouldThrowAnExceptionOnUnSuccessfulCheckoutOfABook() {
        Assertions.assertThrows(BookNotFoundException.class, () -> bookShelf.checkout(new Book("Book3", "Author3", 2000)));
    }

    @Test
    void shouldReturnABook() throws BookNotFoundException {
        bookShelf.checkout(books.get(0));

        bookShelf.returnBook(new Book("Book1", "Author1", 1999));

        Assertions.assertTrue(books.contains(new Book("Book1", "Author1", 1999)));
    }

    @Test
    void shouldThrowAnExceptionOnUnSuccessfulReturnOfABook() {
        Assertions.assertThrows(BookNotFoundException.class, () -> bookShelf.returnBook(new Book("Book3", "Author3", 2000)));
    }

}