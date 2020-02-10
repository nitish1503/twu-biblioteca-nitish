import Exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private final List<Book> books;
    private final List<Book> checkedOutBooks;

    public BookShelf(List<Book> books) {
        this.books = books;
        this.checkedOutBooks = new ArrayList<>();
    }

    public void showBooks() {
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
