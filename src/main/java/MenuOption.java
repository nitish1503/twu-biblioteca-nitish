import Exceptions.BookNotFoundException;

public interface MenuOption {
    void run();
}

class OptionShowBook implements MenuOption {

    private BookShelf bookShelf;
    private Stream stream;

    public OptionShowBook(BookShelf bookShelf, Stream stream) {
        this.bookShelf = bookShelf;
        this.stream = stream;
    }

    @Override
    public void run() {
        bookShelf.showBooks();
        stream.write("\n");
    }
}

class OptionCheckoutBook implements MenuOption {

    private BookShelf bookShelf;
    private Stream stream;

    public OptionCheckoutBook(BookShelf bookShelf, Stream stream) {
        this.bookShelf = bookShelf;
        this.stream = stream;
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
    private Stream stream;

    public OptionReturnBook(BookShelf bookShelf, Stream stream) {
        this.bookShelf = bookShelf;
        this.stream = stream;
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
    private Stream stream;

    public OptionQuit(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        stream.write("Thank You.");
    }
}

class OptionInvalid implements MenuOption {

    private Stream stream;

    public OptionInvalid(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void run() {
        stream.write("Please select a valid option");
    }
}