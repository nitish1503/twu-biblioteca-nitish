import java.util.Objects;

public class Movie {

    private final String name;
    private final int year;
    private final String director;
    private final int rating;
    private Stream stream;

    public Movie(String name, int year, String director, int rating, Stream stream) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.stream = stream;
    }

    public void print() {
        stream.write(name + "\t" + year + "\t" + director + "\t" + rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                rating == movie.rating &&
                Objects.equals(name, movie.name) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(stream, movie.stream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, director, rating, stream);
    }
}
