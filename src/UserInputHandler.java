import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputHandler {
    private final Scanner scanner;

    public UserInputHandler() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.print("> ");
        return scanner.nextLine().trim().toLowerCase();
    }

    public boolean matches(String command, String regex) {
        return Pattern.matches(regex, command);
    }
}
