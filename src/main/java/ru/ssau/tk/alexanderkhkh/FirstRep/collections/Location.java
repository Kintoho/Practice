package ru.ssau.tk.alexanderkhkh.FirstRep.collections;

import java.util.Objects;

public class Location implements Comparable<Location> {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private EquatorComparator equatorComparator = new EquatorComparator();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return id == location.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Location location) {
        return equatorComparator.compare(this, location);
    }

    public enum SettlementType {
        CITY,
        VILLAGE
    }

    public enum WaypointType {
        DEPOT,
        WAREHOUSE,
        EMPTY
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }
}
