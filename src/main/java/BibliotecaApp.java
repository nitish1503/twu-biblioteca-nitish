import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    protected final ArrayList<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));

    private static Menu menu;

    public BibliotecaApp() {
        BookShelf bookShelf = new BookShelf(books);
        menu = new Menu(bookShelf);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        menu.actions();
    }

    public String welcome() {
        return welcomeMessage;
    }

}
