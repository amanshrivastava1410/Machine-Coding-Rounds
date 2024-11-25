package OrderManagementSystem;

import java.util.Map;

public class Order {
    private String orderId;
    private Map<String, Integer> productQuantities;
    private boolean isConfirmed;

    public Order(String orderId, Map<String, Integer> productQuantities) {
        this.orderId = orderId;
        this.productQuantities = productQuantities;
        this.isConfirmed = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getProductQuantities() {
        return productQuantities;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void confirmOrder() {
        this.isConfirmed = true;
    }

    public void cancelOrder() {
        this.isConfirmed = false;
    }
}
