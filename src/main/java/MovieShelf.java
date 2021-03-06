import Exceptions.MovieNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class MovieShelf {
    private final List<Movie> movies;
    private final Stream stream;
    private final List<Movie> checkedOutMovies;

    public MovieShelf(List<Movie> movies, Stream stream) {

        this.movies = movies;
        this.stream = stream;
        checkedOutMovies = new ArrayList<>();
    }

    public void showMovies() {
        stream.write("NAME\tYEAR\tDIRECTOR\tRATING");
        movies.forEach(Movie::print);
    }

    public void checkout(Movie movie) throws MovieNotAvailableException {
        if (movies.contains(movie)) {
            checkedOutMovies.add(movie);
            movies.remove(movie);
        } else
            throw new MovieNotAvailableException();
    }
}
