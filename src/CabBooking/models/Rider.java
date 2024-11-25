package CabBooking.models;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User {
    private List<Ride> rideHistory;

    public Rider(String id, String name, Location location) {
        super(id, name, location);
        this.rideHistory = new ArrayList<>();
    }

    public void addRideToHistory(Ride ride) {
        rideHistory.add(ride);
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }
}
