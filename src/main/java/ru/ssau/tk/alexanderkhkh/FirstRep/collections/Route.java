package ru.ssau.tk.alexanderkhkh.FirstRep.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Route implements Iterable<Location> {
    private List<Location> locations = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Location location : locations) {
            if (location.getClass() == Settlement.class) {
                Settlement settlement = (Settlement) location;
                stringBuilder.append(settlement.toString());
            }
            if (location.getClass() == Waypoint.class) {
                Waypoint waypoint = (Waypoint) location;
                stringBuilder.append(waypoint.toString());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Route route = (Route) object;
        List<Location> objectLocations = route.getLocation();
        if (objectLocations.size() != this.locations.size()) return false;
        for (int i = 0; i < locations.size(); i++) {
            if (!(objectLocations.get(i).equals(locations.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations);
    }

    public List<Location> getLocation() {
        return locations;
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }

    public void addIndexLocation(int index,Location location){
        this.locations.add(index,location);
    }

    public void removeLocation(int index){
        this.locations.remove(index);
    }

    public Location getFirstLocation(){
        return locations.get(0);
    }

    public Location getLastLocation(){
        return locations.get(locations.size()-1);
    }

    public void remove(Location location){
        int count = 0;

        for (Location currentLocation : this.locations) {
            if (currentLocation.equals(location)) {
                removeLocation(count);
                return;
            }
            count++;
        }
    }

    @Override
    public Iterator<Location> iterator() {
        return locations.iterator();
    }
}