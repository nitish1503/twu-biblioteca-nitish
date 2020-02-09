import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class BookShelfTest {

    @Test
    void shouldShowTheListOfBooksWithAuthorAndYearOfPublication() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);

        bookShelf.showBooks();

        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    @Test
    void shouldCheckoutABook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "Book1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);

        bookShelf.checkout();

        bookShelf.showBooks();
        verify(printStream, times(1)).println("Book2 | Author2 | 1990");
    }

    @Test
    void shouldNotifyOnSuccessfulCheckoutOfABook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "Book1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);

        bookShelf.checkout();

        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    void shouldNotifyOnUnSuccessfulCheckoutOfABook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "Book3";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);

        bookShelf.checkout();

        verify(printStream).println("Sorry! that book is not available");
    }

    @Test
    void shouldReturnABook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "Book1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);
        bookShelf.checkout();
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        bookShelf.returnBook();

        bookShelf.showBooks();
        for (Book book : books)
            verify(printStream).println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    @Test
    void shouldNotifyOnSuccessfulReturnOfABook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "Book1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);
        bookShelf.checkout();
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        bookShelf.returnBook();

        verify(printStream).println("Thank you for returning the book");
    }

    @Test
    void shouldNotifyOnUnSuccessfulReturnOfABook() {
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String simulatedUserInput = "Book1";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
        BookShelf bookShelf = new BookShelf(books);

        bookShelf.returnBook();

        verify(printStream).println("That is not a valid book to return");
    }

}