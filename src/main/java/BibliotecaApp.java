import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {
    public static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        System.out.println(bibliotecaApp.showBookList());
    }

    public String welcome() {
        return welcomeMessage;
    }

    public ArrayList<String> showBookList() {
        return new ArrayList<>(Arrays.asList("Book1", "Book2", "Book3"));
    }
}
