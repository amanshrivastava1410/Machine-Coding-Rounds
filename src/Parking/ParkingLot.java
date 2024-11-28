package Parking;

import java.util.*;

public class ParkingLot {
    private String parkingLotId;
    private List<Floor> floors;

    public ParkingLot(String parkingLotId, int numFloors, int numSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.floors = new ArrayList<>();

        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i + 1, numSlotsPerFloor));
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            String ticket = floor.parkVehicle(vehicle, parkingLotId);
            if (ticket != null) {
                return ticket;
            }
        }
        return "Parking Lot Full";
    }

    public String unparkVehicle(String ticketId) {
        for (Floor floor : floors) {
            if (floor.unparkVehicle(ticketId)) {
                return "Unparked vehicle with Ticket ID: " + ticketId;
            }
        }
        return "Invalid Ticket";
    }
    
    

    public void display(String displayType, String vehicleType) {
        for (Floor floor : floors) {
            floor.display(displayType, vehicleType);
        }
    }
}
