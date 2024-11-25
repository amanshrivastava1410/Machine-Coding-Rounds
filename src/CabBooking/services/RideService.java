package CabBooking.services;

import CabBooking.models.Driver;
import CabBooking.models.Rider;
import CabBooking.models.Location;
import CabBooking.models.Ride;
import java.util.*;

public class RideService {
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Rider> riders = new HashMap<>();
    private double ratePerKm;

    public RideService(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public void addRider(Rider rider) {
        riders.put(rider.getId(), rider);
    }

    public void updateLocation(String userId, Location location) {
        if (drivers.containsKey(userId)) {
            drivers.get(userId).updateLocation(location);
        } else if (riders.containsKey(userId)) {
            riders.get(userId).updateLocation(location);
        }
    }

    public Driver findRide(Location pickup) {
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : drivers.values()) {
            if (driver.isAvailable()) {
                double distance = driver.getLocation().calculateDistance(pickup);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestDriver = driver;
                }
            }
        }
        return nearestDriver;
    }

    public Ride bookRide(String riderId, Location pickup, Location drop) {
        Rider rider = riders.get(riderId);
        Driver driver = findRide(pickup);

        if (driver == null) {
            System.out.println("No drivers available.");
            return null;
        }

        driver.setAvailable(false);  // Driver becomes unavailable once a ride is booked
        Ride ride = new Ride(UUID.randomUUID().toString(), rider, driver, pickup, drop);
        rider.addRideToHistory(ride);

        // Printing details of the booked ride
        System.out.println(rider.getName() + " booked a ride: " +
                           "Ride ID: " + ride.getRideId() + ", " +
                           "Pickup: " + ride.getPickup() + ", " +
                           "Drop: " + ride.getDrop());
        System.out.println("Driver: " + driver.getName() + " with car " + driver.getCar().getCarModel());

        return ride;
    }

    public void completeRide(Ride ride) {
        ride.getDriver().setAvailable(true);  // Mark the driver as available
        double fare = ride.calculateFare(ratePerKm);  // Calculate the fare based on distance
        System.out.println("Ride completed. Fare: " + fare + " (Distance: " + ride.getDistance() + " km)");
        System.out.println("Pickup Location: " + ride.getPickup() + ", Drop Location: " + ride.getDrop());
    }
}
