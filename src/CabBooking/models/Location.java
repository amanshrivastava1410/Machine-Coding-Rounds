package CabBooking.models;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double calculateDistance(Location other) {
        double x = this.latitude - other.latitude;
        double y = this.longitude - other.longitude;
        return Math.sqrt(x * x + y * y);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Location { " +
               "latitude = " + latitude +
               ", longitude = " + longitude +
               '}';
    }
}
