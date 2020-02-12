import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    List<User> users;
    User currentUser;
    private static Stream stream;
    private static Menu menu;

    BookShelf bookShelf;
    MovieShelf movieShelf;

    public BibliotecaApp() {
        stream = new Stream(new PrintStream(System.out));
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("Book1", "Author1", 1999, stream),
                new Book("Book2", "Author2", 1990, stream)));
        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Movie1", 2019, "Director1", 9, stream),
                new Movie("Movie2", 2018, "Director2", 8, stream)));

        users = new ArrayList<>(Arrays.asList(new User("ABC-1234", "password", stream),
                new User("ABC-5678", "password", stream)));
        currentUser = new User("XXX-XXXX", "xxxxxxxx", stream);

        bookShelf = new BookShelf(books, currentUser, stream);
        movieShelf = new MovieShelf(movies, stream);

        menu = new Menu(this, bookShelf, movieShelf, stream);
    }

    public String welcome() {
        return welcomeMessage;
    }


    public void login(User user) {
        if (users.contains(user)) {
            currentUser = user;
            bookShelf.setCurrentUser(user);
        }
    }

    public void showCurrentUser() {
        if (!currentUser.equals(new User("XXX-XXXX", "xxxxxxxx", stream)))
            currentUser.show();
        else
            stream.write("Please login and try again");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        stream.write(bibliotecaApp.welcome());
        menu.actions();
    }
}
