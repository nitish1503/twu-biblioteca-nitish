import java.io.PrintStream;
import java.util.Scanner;

public class Stream {

    private PrintStream printStream;

    public Stream(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void write(String message) {
        printStream.println(message);
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

    public Movie readMovie() {
        Scanner scanner = new Scanner(System.in);
        write("Enter movie name:");
        String name = scanner.next();
        write("Enter year: ");
        int year = scanner.nextInt();
        write("Enter director name: ");
        String director = scanner.next();
        write("Enter rating: ");
        int rating = scanner.nextInt();
        return new Movie(name, year, director, rating, this);
    }

    public User readUser() {
        Scanner scanner = new Scanner(System.in);
        write("Enter Library Id (XXX-XXXX):");
        String libraryId = scanner.next();
        write("Enter password: ");
        String password = scanner.next();
        return new User(libraryId, password);
    }
}
