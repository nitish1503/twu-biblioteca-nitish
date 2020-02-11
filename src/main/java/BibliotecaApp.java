import Exceptions.InvalidOptionException;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private static Stream stream;
    private static Menu menu;

    public BibliotecaApp() {
        stream = new Stream();
        List<Book> books = Arrays.asList(
                new Book("Book1", "Author1", 1999, stream),
                new Book("Book2", "Author2", 1990, stream));
        BookShelf bookShelf = new BookShelf(books, stream);
        menu = new Menu(bookShelf, stream);
    }

    public String welcome() {
        return welcomeMessage;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        stream.write(bibliotecaApp.welcome());
        try {
            menu.actions();
        } catch (InvalidOptionException e) {
            stream.write("Please select a valid option..");
        }

    }
}
