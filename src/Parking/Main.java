package Parking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;
        
        while (true) {
            String command = scanner.nextLine();
            String[] inputs = command.split(" ");
            
            if (inputs[0].equals("create_parking_lot")) {
                String parkingLotId = inputs[1];
                int numFloors = Integer.parseInt(inputs[2]);
                int numSlotsPerFloor = Integer.parseInt(inputs[3]);
                parkingLot = new ParkingLot(parkingLotId, numFloors, numSlotsPerFloor);
                System.out.println("Created parking lot with " + numFloors + " floors and " + numSlotsPerFloor + " slots per floor");
                
            } else if (inputs[0].equals("park_vehicle")) {
                if (parkingLot != null) {
                    String vehicleType = inputs[1];
                    String regNo = inputs[2];
                    String color = inputs[3];
                    Vehicle vehicle = new Vehicle(vehicleType, regNo, color);
                    String ticket = parkingLot.parkVehicle(vehicle);
                    if (ticket.equals("Parking Lot Full")) {
                        System.out.println(ticket);
                    } else {
                        System.out.println("Parked vehicle. Ticket ID: " + ticket);
                    }
                }
                
            } else if (inputs[0].equals("unpark_vehicle")) {
                if (parkingLot != null) {
                    String ticketId = inputs[1];
                    System.out.println(parkingLot.unparkVehicle(ticketId));
                }
                
            } else if (inputs[0].equals("display")) {
                if (parkingLot != null) {
                    String displayType = inputs[1];
                    String vehicleType = inputs[2];
                    parkingLot.display(displayType, vehicleType);
                }
                
            } else if (inputs[0].equals("exit")) {
                break;
            }
        }
        scanner.close();
    }
}

