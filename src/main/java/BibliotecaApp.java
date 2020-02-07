public class BibliotecaApp {
    public static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcome();
    }

    public String welcome() {
        return welcomeMessage;
    }
}
