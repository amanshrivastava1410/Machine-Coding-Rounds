package CabBooking.models;

public abstract class User {
    protected String id;
    protected String name;
    protected Location location;

    public User(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
