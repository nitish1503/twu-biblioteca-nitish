import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private static final String menu = "1. List of books";
    private final List<Book> books = Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990));

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        bibliotecaApp.menu();
    }

    public String welcome() {
        return welcomeMessage;
    }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    public void menu() {
        System.out.println(menu);
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        if (option == 1) {
            showBooks();
        }
    }
}
