import java.util.Objects;

public class User {

    private final String libraryId;
    private final String password;

    public User(String libraryId, String password) {
        this.libraryId = libraryId;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(libraryId, user.libraryId) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, password);
    }
}
