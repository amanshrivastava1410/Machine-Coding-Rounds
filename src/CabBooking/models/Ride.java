package CabBooking.models;

public class Ride {
    private String rideId;
    private Rider rider;
    private Driver driver;
    private Location pickup;
    private Location drop;
    private double distance;
    private double fare;

    public Ride(String rideId, Rider rider, Driver driver, Location pickup, Location drop) {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.pickup = pickup;
        this.drop = drop;
        this.distance = pickup.calculateDistance(drop);
    }

    public double calculateFare(double ratePerKm) {
        this.fare = this.distance * ratePerKm;
        return fare;
    }
    
    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getPickup() {
        return pickup;
    }

    public Location getDrop() {
        return drop;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }
}
