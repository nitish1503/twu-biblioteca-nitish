import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    public static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private List<String> bookList = new ArrayList<>(Arrays.asList("Book1", "Book2", "Book3"));

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        System.out.println(bibliotecaApp.getBooks());
    }

    public String welcome() {
        return welcomeMessage;
    }

    public List<String> getBooks() {
        return bookList;
    }
}
