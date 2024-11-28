package Parking;

import java.util.*;

public class Floor {
    private int floorNo;
    private List<ParkingSlot> slots;

    public Floor(int floorNo, int numSlots) {
        this.floorNo = floorNo;
        this.slots = new ArrayList<>();

        for (int i = 1; i <= numSlots; i++) {
            if (i == 1) {
                slots.add(new ParkingSlot(i, "TRUCK"));
            } else if (i == 2 || i == 3) {
                slots.add(new ParkingSlot(i, "BIKE"));
            } else {
                slots.add(new ParkingSlot(i, "CAR"));
            }
        }
    }

    public String parkVehicle(Vehicle vehicle, String parkingLotId) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.getSlotType().equals(vehicle.getVehicleType())) {
                slot.parkVehicle(vehicle, floorNo);
                return parkingTicket(slot);
            }
        }
        return null;
    }

    public boolean unparkVehicle(String ticketId) {
        for (ParkingSlot slot : slots) {
            if (slot.getTicketId() != null && slot.getTicketId().equals(ticketId)) {
                // Only unpark if ticket matches and vehicle is still parked
                slot.unparkVehicle();
                return true;
            }
        }
        return false; // If the ticket does not match any parked vehicle, return false
    }

    public void display(String displayType, String vehicleType) {
        List<Integer> freeSlots = new ArrayList<>();
        
        // Only track free slots for the specified vehicle type
        for (ParkingSlot slot : slots) {
            if (slot.getSlotType().equals(vehicleType) && !slot.isOccupied()) {
                freeSlots.add(slot.getSlotNo());
            }
        }
    
        if ("free_count".equals(displayType)) {
            // Print only the free slot count for the given vehicle type
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + floorNo + ": " + freeSlots.size());
        } else if ("free_slots".equals(displayType)) {
            // Print the specific free slot numbers
            System.out.print("Free slots for " + vehicleType + " on Floor " + floorNo + ": ");
            System.out.println(freeSlots.toString().replace("[", "").replace("]", ""));
        } else if ("occupied_slots".equals(displayType)) {
            // If you want to display occupied slots as well, this is how
            List<Integer> occupiedSlots = new ArrayList<>();
            for (ParkingSlot slot : slots) {
                if (slot.getSlotType().equals(vehicleType) && slot.isOccupied()) {
                    occupiedSlots.add(slot.getSlotNo());
                }
            }
            System.out.print("Occupied slots for " + vehicleType + " on Floor " + floorNo + ": ");
            System.out.println(occupiedSlots.toString().replace("[", "").replace("]", ""));
        }
    }
    
    

    private String parkingTicket(ParkingSlot slot) {
        return "PR1234_" + floorNo + "_" + slot.getSlotNo();
    }
}
