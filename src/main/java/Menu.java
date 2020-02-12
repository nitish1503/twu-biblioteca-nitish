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
            default:
                return new OptionInvalid(stream);
        }
    }
}
