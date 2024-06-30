package locations;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final String name;
    private final String description;
    private final List<Location> neighbors;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Location> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Location neighbor) {
        this.neighbors.add(neighbor);
    }

}
