import Exceptions.BookNotFoundException;

import java.util.Scanner;

public class Menu {
    private static final String menu = "1. List of books\n2. Checkout\n3. Return\n4. Quit";
    private static final int OPTION_SHOW_BOOK = 1;
    private static final int OPTION_CHECKOUT_BOOK = 2;
    private static final int OPTION_RETURN_BOOK = 3;
    private static final int OPTION_QUIT = 4;

    private BookShelf bookShelf;

    public Menu(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public void display() {
        System.out.println(menu);
        System.out.println("Please select your choice...");
    }

    public void actions() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            String title;
            String author;
            int yearOfPublication;

            display();
            option = sc.nextInt();

            switch (option) {

                case OPTION_SHOW_BOOK:
                    bookShelf.showBooks();
                    break;
                case OPTION_CHECKOUT_BOOK:
                    System.out.println("Enter book title:");
                    title = sc.next();
                    System.out.println("Enter book author: ");
                    author = sc.next();
                    System.out.println("Enter year of publication: ");
                    yearOfPublication = sc.nextInt();

                    try {
                        bookShelf.checkout(new Book(title, author, yearOfPublication));
                        System.out.println("Thank you! Enjoy the book");
                    } catch (BookNotFoundException e) {
                        System.out.println("Sorry!" + title + " book is not available for checkout");
                    }
                    break;
                case OPTION_RETURN_BOOK:
                    System.out.println("Enter book title:");
                    title = sc.next();
                    System.out.println("Enter book author: ");
                    author = sc.next();
                    System.out.println("Enter year of publication: ");
                    yearOfPublication = sc.nextInt();

                    try {
                        bookShelf.returnBook(new Book(title, author, yearOfPublication));
                        System.out.println("Thanks for returning the book");
                    } catch (BookNotFoundException e) {
                        System.out.println("Sorry!" + title + " book is not valid for return");
                    }
                    break;
                case OPTION_QUIT:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
        } while (option != OPTION_QUIT);

        sc.close();
    }
}
