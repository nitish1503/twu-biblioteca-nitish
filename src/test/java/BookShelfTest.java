import Exceptions.BookNotFoundException;
import Exceptions.InvalidUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class BookShelfTest {

    BookShelf bookShelf;
    List<Book> books;
    Stream stream;

    @BeforeEach
    void setup() {
        stream = mock(Stream.class);
        books = new ArrayList<>(Arrays.asList(
                new Book("Book1", "Author1", 1999, stream),
                new Book("Book2", "Author2", 1990, stream)));
        bookShelf = new BookShelf(books, mock(User.class), stream);
    }

    @Test
    void shouldShowTheListOfBooksWithAuthorAndYearOfPublication() {
        bookShelf.showBooks();

        verify(stream).write("Book1\tAuthor1\t\t1999");
        verify(stream).write("Book2\tAuthor2\t\t1990");
    }

    @Test
    void shouldCheckoutABook() throws BookNotFoundException, InvalidUserException {
        bookShelf.checkout(books.get(0));

        Assertions.assertFalse(books.contains(new Book("Book1", "Author1", 1999, stream)));
    }

    @Test
    void shouldThrowAnExceptionOnUnSuccessfulCheckoutOfABook() {
        Assertions.assertThrows(BookNotFoundException.class, () ->
                bookShelf.checkout(new Book("Book3", "Author3", 2000, stream)));
    }

    @Test
    void shouldReturnABook() throws BookNotFoundException, InvalidUserException {
        bookShelf.checkout(books.get(0));

        bookShelf.returnBook(new Book("Book1", "Author1", 1999, stream));

        Assertions.assertTrue(books.contains(new Book("Book1", "Author1", 1999, stream)));
    }

    @Test
    void shouldThrowAnExceptionOnUnSuccessfulReturnOfABook() {
        Assertions.assertThrows(BookNotFoundException.class, () -> bookShelf.returnBook(
                new Book("Book3", "Author3", 2000, stream)));
    }

    @Test
    void shouldNotCheckoutABookIfUserIsNotLoggedIn() {
        BookShelf bookShelf = new BookShelf(books, new User("XXX-XXXX", "xxxxxxxx"), stream);

        Assertions.assertThrows(InvalidUserException.class, () -> bookShelf.checkout(books.get(0)));
    }
}