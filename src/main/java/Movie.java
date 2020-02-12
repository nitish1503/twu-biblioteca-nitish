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

}
