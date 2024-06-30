public class GameInit {
    private static final UserInputHandler userInputHandler = new UserInputHandler();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            String command = userInputHandler.getUserInput();

            if (userInputHandler.matches(command, "1|новая игра")) {
                GameLoop gameLoop = new GameLoop();
                gameLoop.start();
            } else if (userInputHandler.matches(command, "2|выход")) {
                running = false;
                System.out.println("Выход из игры.");
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }

            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.println("1. [Начать игру]");
        System.out.println("2. [Выход]");
    }
}
