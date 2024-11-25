package CabBooking.app;

import CabBooking.models.*;
import CabBooking.services.RideService;

public class Main {
    public static void main(String[] args) {
        RideService rideService = new RideService(10.0);

        Driver driver1 = new Driver("Driver 1", "Lionel", new Location(0, 0), new Car("ABC123", "Toyota"));
        Driver driver2 = new Driver("Driver 2", "Doe", new Location(1, 1), new Car("XYZ789", "Honda"));
        rideService.addDriver(driver1);
        rideService.addDriver(driver2);

        Rider rider1 = new Rider("R1", "Alice", new Location(2, 2));
        rideService.addRider(rider1);

        Location pickup = new Location(2, 2);
        Location drop = new Location(5, 5);

        Ride ride = rideService.bookRide("R1", pickup, drop);

        if (ride != null) {
            rideService.completeRide(ride);
        }
    }
}
