package Parking;

public class Vehicle {
    private String vehicleType;
    private String regNo;
    private String color;

    public Vehicle(String vehicleType, String regNo, String color) {
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }
}
