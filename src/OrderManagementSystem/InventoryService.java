package OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(String productId, int quantity) {
        Product product = inventory.getOrDefault(productId, new Product(productId, 0));
        product.addStock(quantity);
        inventory.put(productId, product);
    }

    public Order createOrder(String orderId, Map<String, Integer> productQuantities) {
        Order order = new Order(orderId, productQuantities);
        try {
            for (Map.Entry<String, Integer> entry : productQuantities.entrySet()) {
                String productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = inventory.get(productId);

                if (product != null) {
                    product.lockStock(quantity);
                } else {
                    throw new IllegalArgumentException("Product not found: " + productId);
                }
            }
            return order;
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create order: " + e.getMessage());
            return null;
        }
    }

    public void confirmOrder(Order order) {
        if (order != null && !order.isConfirmed()) {
            for (Map.Entry<String, Integer> entry : order.getProductQuantities().entrySet()) {
                String productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = inventory.get(productId);

                if (product != null) {
                    product.reduceStock(quantity);
                    product.unlockStock(quantity);
                }
            }
            order.confirmOrder();
            System.out.println("Order " + order.getOrderId() + " confirmed.");
        }
    }

    public int getStock(String productId) {
        Product product = inventory.get(productId);
        if (product != null) {
            return product.getAvailableStock();
        }
        return 0;
    }
}

