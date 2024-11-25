package CabBooking.models;

public class Driver extends User {
    private boolean isAvailable;
    private Car car;

    public Driver(String id, String name, Location location, Car car) {
        super(id, name, location);
        this.car = car;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Car getCar() {
        return car;
    }
}
