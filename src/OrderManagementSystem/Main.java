package OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();

        inventoryService.addProduct("P1", 100);
        inventoryService.addProduct("P2", 50);

        Map<String, Integer> orderProducts = new HashMap<>();
        orderProducts.put("P1", 10);
        orderProducts.put("P2", 5);

        Order order = inventoryService.createOrder("O1", orderProducts);
        if (order != null) {
            System.out.println("Order created successfully.");

            inventoryService.confirmOrder(order);
        }

        System.out.println("Stock of P1: " + inventoryService.getStock("P1"));
        System.out.println("Stock of P2: " + inventoryService.getStock("P2"));
    }
}
