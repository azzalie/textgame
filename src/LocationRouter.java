import locations.*;

import java.util.HashMap;
import java.util.Map;

public class LocationRouter {
    private final Map<String, Location> locations;

    public LocationRouter() {
        locations = new HashMap<>();
        initializeLocations();
    }

    private void initializeLocations() {
        Location startLocation = new StartLocation();
        Location ilocation = new ILocation();
        Location iilocation = new IILocation();
        Location iiilocation = new IIILocation();
        Location ivlocation = new IVLocation();
        Location vlocation = new VLocation();

        startLocation.addNeighbor(ilocation);
        startLocation.addNeighbor(iilocation);
        startLocation.addNeighbor(iiilocation);
        startLocation.addNeighbor(ivlocation);
        startLocation.addNeighbor(vlocation);

        ilocation.addNeighbor(startLocation);
        ilocation.addNeighbor(iiilocation);
        ilocation.addNeighbor(ivlocation);

        iilocation.addNeighbor(startLocation);
        iilocation.addNeighbor(ivlocation);
        iilocation.addNeighbor(vlocation);

        iiilocation.addNeighbor(startLocation);
        iiilocation.addNeighbor(ilocation);
        iiilocation.addNeighbor(vlocation);

        ivlocation.addNeighbor(startLocation);
        ivlocation.addNeighbor(ilocation);
        ivlocation.addNeighbor(iilocation);

        vlocation.addNeighbor(startLocation);
        vlocation.addNeighbor(iilocation);
        vlocation.addNeighbor(iiilocation);

        locations.put(startLocation.getName().toLowerCase(), startLocation);
        locations.put(ilocation.getName().toLowerCase(), ilocation);
        locations.put(iilocation.getName().toLowerCase(), iilocation);
        locations.put(iiilocation.getName().toLowerCase(), iiilocation);
        locations.put(ivlocation.getName().toLowerCase(), ivlocation);
        locations.put(vlocation.getName().toLowerCase(), vlocation);
    }

    public Location getLocation(String name) {
        return locations.get(name.toLowerCase());
    }

}
