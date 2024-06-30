import locations.Location;

public class GameLoop {
    private final UserInputHandler userInputHandler;
    private final LocationRouter locationRouter;
    private final Player player;

    public GameLoop() {
        userInputHandler = new UserInputHandler();
        locationRouter = new LocationRouter();
        Location startLocation = locationRouter.getLocation("Start");
        player = new Player(startLocation);
    }

    public void start() {
        boolean running = true;
        while (running) {
            Location currentLocation = player.getCurrentLocation();
            System.out.println(currentLocation.getName());
            System.out.println(currentLocation.getDescription());

            System.out.println("Доступные локации:");
            for (Location neighbor : currentLocation.getNeighbors()) {
                System.out.println("- " + neighbor.getName());
            }

            System.out.println("Введите имя локации для перехода или 'x' для завершения игры:");
            String command = userInputHandler.getUserInput();

            if (userInputHandler.matches(command, "x|х|завершить игру")) {
                running = false;
                System.out.println("Игра завершена. Возвращаемся в главное меню.");
            } else {
                Location newLocation = locationRouter.getLocation(command);
                if (newLocation != null && currentLocation.getNeighbors().contains(newLocation)) {
                    player.setCurrentLocation(newLocation);
                } else if (newLocation == currentLocation) {
                    System.out.println("Вы уже находитесь в этой локации.");
                } else {
                    System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }

            System.out.println();
        }
    }
}
