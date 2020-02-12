import java.util.List;

public class MovieShelf {
    private final List<Movie> movies;
    private final Stream stream;

    public MovieShelf(List<Movie> movies, Stream stream) {

        this.movies = movies;
        this.stream = stream;
    }

    public void showMovies() {
        movies.forEach(Movie::print);
    }
}
