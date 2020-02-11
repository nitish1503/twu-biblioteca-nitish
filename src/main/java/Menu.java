import Exceptions.BookNotFoundException;
import Exceptions.InvalidOptionException;

public class Menu {
    private static final String menu = "1. List of books\n2. Checkout\n3. Return\n4. Quit";
    private static final int OPTION_SHOW_BOOK = 1;
    private static final int OPTION_CHECKOUT_BOOK = 2;
    private static final int OPTION_RETURN_BOOK = 3;
    private static final int OPTION_QUIT = 4;

    private BookShelf bookShelf;
    private Stream stream;

    public Menu(BookShelf bookShelf, Stream stream) {
        this.bookShelf = bookShelf;
        this.stream = stream;
    }

    public void display() {
        stream.write(menu);
        stream.write("Please select your choice...");
    }

    public void actions() throws InvalidOptionException {
        int option;

        do {
            display();
            option = stream.readInt();
            switch (option) {
                case OPTION_SHOW_BOOK:
                    bookShelf.showBooks();
                    stream.write("\n");
                    break;
                case OPTION_CHECKOUT_BOOK:
                    try {
                        bookShelf.checkout(stream.readBook());
                        stream.write("Thank you! Enjoy the book");
                    } catch (BookNotFoundException e) {
                        stream.write("Sorry! that book is not available for checkout");
                    }
                    break;
                case OPTION_RETURN_BOOK:
                    try {
                        bookShelf.returnBook(stream.readBook());
                        stream.write("Thanks for returning the book");
                    } catch (BookNotFoundException e) {
                        stream.write("Sorry! that book is not valid for return");
                    }
                    break;
                case OPTION_QUIT:
                    stream.write("Thank You!");
                    break;
                default:
                    throw new InvalidOptionException();
            }
        } while (option != OPTION_QUIT);

    }
}
