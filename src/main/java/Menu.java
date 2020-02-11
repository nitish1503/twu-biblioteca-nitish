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

    public Menu(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        stream = new Stream();
    }

    public void display() {
        System.out.println(menu);
        System.out.println("Please select your choice...");
    }

    public void actions() throws InvalidOptionException {
        int option;

        do {
            display();
            option = stream.readOption();
            switch (option) {
                case OPTION_SHOW_BOOK:
                    bookShelf.showBooks();
                    System.out.println();
                    break;
                case OPTION_CHECKOUT_BOOK:
                    try {
                        bookShelf.checkout(stream.readBook());
                        stream.checkoutMessage();
                    } catch (BookNotFoundException e) {
                        stream.bookUnAvailableForCheckout();
                    }
                    break;
                case OPTION_RETURN_BOOK:
                    try {
                        bookShelf.returnBook(stream.readBook());
                        stream.returnBookMessage();
                    } catch (BookNotFoundException e) {
                        stream.bookUnAvailableForReturn();
                    }
                    break;
                case OPTION_QUIT:
                    stream.thankYou();
                    break;
                default:
                    throw new InvalidOptionException();
            }
        } while (option != OPTION_QUIT);

    }
}
