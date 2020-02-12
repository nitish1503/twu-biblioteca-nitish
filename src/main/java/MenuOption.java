import Exceptions.ApplicationClosedException;
import Exceptions.BookNotFoundException;

import java.io.PrintStream;

public interface MenuOption {
    Stream stream = new Stream(new PrintStream(System.out));

    void run() throws ApplicationClosedException;
}

class OptionShowBook implements MenuOption {

    private BookShelf bookShelf;

    public OptionShowBook(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public void run() {
        bookShelf.showBooks();
        stream.write("\n");
    }
}

class OptionCheckoutBook implements MenuOption {

    private BookShelf bookShelf;

    public OptionCheckoutBook(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public void run() {
        try {
            bookShelf.checkout(stream.readBook());
            stream.write("Thank you! Enjoy the book");
        } catch (BookNotFoundException e) {
            stream.write("Sorry! that book is not available for checkout");
        }
    }
}

class OptionReturnBook implements MenuOption {
    private BookShelf bookShelf;

    public OptionReturnBook(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public void run() {
        try {
            bookShelf.returnBook(stream.readBook());
            stream.write("Thanks for returning the book");
        } catch (BookNotFoundException e) {
            stream.write("Sorry! that book is not valid for return");
        }
    }
}

class OptionQuit implements MenuOption {

    @Override
    public void run() throws ApplicationClosedException {
        throw new ApplicationClosedException();
    }
}