package Parking;

public class ParkingSlot {
    private int slotNo;
    private String slotType;
    private boolean isOccupied;
    private Vehicle occupiedBy;
    private String ticketId;

    public ParkingSlot(int slotNo, String slotType) {
        this.slotNo = slotNo;
        this.slotType = slotType;
        this.isOccupied = false;
        this.occupiedBy = null; 
        this.ticketId = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void parkVehicle(Vehicle vehicle, int floorNo) {
        this.isOccupied = true; 
        this.occupiedBy = vehicle; 
        this.ticketId = "PR1234_" + floorNo + "_" + slotNo;  
    }

    public void unparkVehicle() {
        this.isOccupied = false;
        this.occupiedBy = null;
        this.ticketId = null;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public String getSlotType() {
        return slotType;
    }

    public Vehicle getOccupiedBy() {
        return occupiedBy;
    }
}
