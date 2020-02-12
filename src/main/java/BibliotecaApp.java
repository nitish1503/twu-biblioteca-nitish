import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private static Stream stream;
    private static Menu menu;

    public BibliotecaApp() {
        stream = new Stream(new PrintStream(System.out));
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("Book1", "Author1", 1999, stream),
                new Book("Book2", "Author2", 1990, stream)));
        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Movie1", 2019, "Director1", 9, stream),
                new Movie("Movie2", 2018, "Director2", 8, stream)));
        BookShelf bookShelf = new BookShelf(books, stream);
        MovieShelf movieShelf = new MovieShelf(movies, stream);

        menu = new Menu(bookShelf, movieShelf, stream);
    }

    public String welcome() {
        return welcomeMessage;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        stream.write(bibliotecaApp.welcome());
        menu.actions();
    }
}
