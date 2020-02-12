import Exceptions.BookNotFoundException;
import Exceptions.InvalidUserException;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private final List<Book> books;
    private final List<Book> checkedOutBooks;
    private User currentUser;
    private final Stream stream;

    public BookShelf(List<Book> books, User currentUser, Stream stream) {
        this.books = books;
        this.currentUser = currentUser;
        this.stream = stream;
        this.checkedOutBooks = new ArrayList<>();
    }

    public void showBooks() {
        stream.write("TITLE\tAUTHOR\t\tYEAR OF PUBLICATION");
        books.forEach(Book::print);
    }

    public void checkout(Book book) throws BookNotFoundException, InvalidUserException {
        if (!currentUser.equals(new User("XXX-XXXX", "xxxxxxxx", stream))) {
            if (books.contains(book)) {
                checkedOutBooks.add(book);
                books.remove(book);
            } else
                throw new BookNotFoundException();
        } else
            throw new InvalidUserException();

    }

    public void returnBook(Book book) throws BookNotFoundException {
        if (checkedOutBooks.contains(book) && currentUser.getCheckedOutBooks().contains(book)) {
            books.add(book);
            checkedOutBooks.remove(book);
        } else
            throw new BookNotFoundException();
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }
}
