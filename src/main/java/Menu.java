public class Menu {
    private static final String menu = "1. List of books\n2. Checkout\n3. Return\n4. Quit\n5. List of movies\n6. Checkout movie\n7. Login\n8. My Details";
    private static final int OPTION_SHOW_BOOK = 1;
    private static final int OPTION_CHECKOUT_BOOK = 2;
    private static final int OPTION_RETURN_BOOK = 3;
    private static final int OPTION_QUIT = 4;
    private static final int OPTION_SHOW_MOVIE = 5;
    private static final int OPTION_CHECKOUT_MOVIE = 6;
    private static final int OPTION_LOGIN = 7;
    private static final int OPTION_SHOW_USER_DETAILS = 8;


    private BibliotecaApp bibliotecaApp;
    private BookShelf bookShelf;
    private MovieShelf movieShelf;
    private Stream stream;

    public Menu(BibliotecaApp bibliotecaApp, BookShelf bookShelf, MovieShelf movieShelf, Stream stream) {
        this.bibliotecaApp = bibliotecaApp;
        this.bookShelf = bookShelf;
        this.movieShelf = movieShelf;
        this.stream = stream;
    }

    public void display() {
        stream.write(menu);
        stream.write("Please select your choice...");
    }

    public void actions() {
        int option;

        do {
            display();
            option = stream.readInt();
            MenuOption menuOption = findOption(option);
            menuOption.run();
        } while (option != OPTION_QUIT);
    }

    private MenuOption findOption(int option) {
        switch (option) {
            case OPTION_SHOW_BOOK:
                return new OptionShowBook(bookShelf, stream);
            case OPTION_CHECKOUT_BOOK:
                return new OptionCheckoutBook(bookShelf, stream);
            case OPTION_RETURN_BOOK:
                return new OptionReturnBook(bookShelf, stream);
            case OPTION_QUIT:
                return new OptionQuit(stream);
            case OPTION_SHOW_MOVIE:
                return new OptionShowMovie(movieShelf, stream);
            case OPTION_CHECKOUT_MOVIE:
                return new OptionCheckoutMovie(movieShelf, stream);
            case OPTION_LOGIN:
                return new OptionLogin(bibliotecaApp, stream);
            case OPTION_SHOW_USER_DETAILS:
                return new OptionShowUserDetails(bibliotecaApp, stream);
            default:
                return new OptionInvalid(stream);
        }
    }
}
