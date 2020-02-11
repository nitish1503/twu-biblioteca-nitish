import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int yearOfPublication;
    private final Stream stream;

    public Book(String title, String author, int yearOfPublication, Stream stream) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.stream = stream;
    }

    public void print() {
        stream.write(this.title + "\t" + this.author + "\t\t" + this.yearOfPublication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublication == book.yearOfPublication &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfPublication);
    }
}
