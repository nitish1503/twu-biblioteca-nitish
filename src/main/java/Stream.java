import java.util.Scanner;

public class Stream {

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Book readBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String title = scanner.next();
        System.out.println("Enter book author: ");
        String author = scanner.next();
        System.out.println("Enter year of publication: ");
        int yearOfPublication = scanner.nextInt();
        return new Book(title, author, yearOfPublication);
    }

    public void checkoutMessage() {
        System.out.println("Thank you! Enjoy the book");
    }

    public void bookUnAvailableForCheckout() {
        System.out.println("Sorry! that book is not available for checkout");
    }

    public void returnBookMessage() {
        System.out.println("Thanks for returning the book");
    }

    public void bookUnAvailableForReturn() {
        System.out.println("Sorry! that book is not valid for return");
    }

    public void thankYou() {
        System.out.println("Thank You!");
    }

}
