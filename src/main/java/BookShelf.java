import Exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private final List<Book> books;
    private final List<Book> checkedOutBooks;
    private final Stream stream;

    public BookShelf(List<Book> books, Stream stream) {
        this.books = books;
        this.stream = stream;
        this.checkedOutBooks = new ArrayList<>();
    }

    public void showBooks() {
        stream.write("TITLE\tAUTHOR\t\tYEAR OF PUBLICATION");
        books.forEach(Book::print);
    }

    public void checkout(Book book) throws BookNotFoundException {
        if (books.contains(book)) {
            checkedOutBooks.add(book);
            books.remove(book);
        } else
            throw new BookNotFoundException();
    }

    public void returnBook(Book book) throws BookNotFoundException {
        if (checkedOutBooks.contains(book)) {
            books.add(book);
            checkedOutBooks.remove(book);
        } else
            throw new BookNotFoundException();
    }
}
