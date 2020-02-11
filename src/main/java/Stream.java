import java.util.Scanner;

public class Stream {

    public void write(String message) {
        System.out.println(message);
    }

    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Book readBook() {
        Scanner scanner = new Scanner(System.in);
        write("Enter book title:");
        String title = scanner.next();
        write("Enter book author: ");
        String author = scanner.next();
        write("Enter year of publication: ");
        int yearOfPublication = scanner.nextInt();
        return new Book(title, author, yearOfPublication, this);
    }

}
