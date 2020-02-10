import java.util.Scanner;

public class Menu {
    private static final String menu = "1. List of books\n2. Checkout\n3. Return\n4. Quit";
    private static final int OPTION_ONE = 1;
    private static final int OPTION_TWO = 2;
    private static final int OPTION_THREE = 3;
    private static final int OPTION_FOUR = 4;

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
            display();
            option = sc.nextInt();

            if (option == OPTION_ONE)
                bookShelf.showBooks();
            else if (option == OPTION_TWO)
                bookShelf.checkout();
            else if (option == OPTION_THREE)
                bookShelf.returnBook();
            else if (option == OPTION_FOUR) {
                System.out.println("Thank You!");
            } else
                System.out.println("Please select a valid option!");
        } while (option != 4);

        sc.close();
    }
}
