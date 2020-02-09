import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private static final String menu = "1. List of books\n4. Quit";
    private final List<Book> books = new ArrayList<>(Arrays.asList(new Book("Book1", "Author1", 1999), new Book("Book2", "Author2", 1990)));
    private final List<Book> checkedOutBooks = new ArrayList<>();

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
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println(menu);
            System.out.println("Please select your choice...");
            option = sc.nextInt();

            if (option == 1)
                showBooks();
            else if (option == 2)
                checkout();
            else if (option == 4) {
                System.out.println("Thank You!");
            } else
                System.out.println("Please select a valid option!");
        } while (option != 4);

        sc.close();

    }

    public void checkout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book title to checkout: ");
        String bookTitle = sc.next();
        for (Book book : books) {
            if (bookTitle.equals(book.getTitle())) {
                checkedOutBooks.add(book);
                books.remove(book);
                return;
            }
        }
    }
}
