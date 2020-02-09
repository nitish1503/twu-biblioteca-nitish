import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShelf {
    protected final List<Book> books;
    private final List<Book> checkedOutBooks;

    public BookShelf(ArrayList<Book> books) {
        this.books = books;
        this.checkedOutBooks = new ArrayList<>();
    }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearOfPublication());
    }

    public void checkout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book title to checkout: ");
        String bookTitle = sc.next();
        for (Book book : books) {
            if (bookTitle.equals(book.getTitle())) {
                checkedOutBooks.add(book);
                books.remove(book);
                System.out.println("Thank you! Enjoy the book");
                return;
            }
        }
        System.out.println("Sorry! that book is not available");
    }

    public void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book title to return: ");
        String bookTitle = sc.next();
        for (Book book : checkedOutBooks) {
            if (bookTitle.equals(book.getTitle())) {
                books.add(book);
                checkedOutBooks.remove(book);
                System.out.println("Thank you for returning the book");
                return;
            }
        }
        System.out.println("That is not a valid book to return");
    }
}
