import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final List<Book> books = Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990));

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        bibliotecaApp.showBooks();
    }

    public String welcome() {
        return welcomeMessage;
    }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }
}
