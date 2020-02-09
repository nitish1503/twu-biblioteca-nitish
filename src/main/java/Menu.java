import java.util.Scanner;

public class Menu {
    private static final String menu = "1. List of books\n2. Checkout\n3. Return\n4. Quit";
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

            if (option == 1)
                bookShelf.showBooks();
            else if (option == 2)
                bookShelf.checkout();
            else if (option == 3)
                bookShelf.returnBook();
            else if (option == 4) {
                System.out.println("Thank You!");
            } else
                System.out.println("Please select a valid option!");
        } while (option != 4);

        sc.close();
    }
}
