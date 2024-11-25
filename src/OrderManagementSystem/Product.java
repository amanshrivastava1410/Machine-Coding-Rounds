package OrderManagementSystem;

public class Product {
    private String productId;
    private int availableStock;
    private int lockedStock;

    public Product(String productId, int availableStock) {
        this.productId = productId;
        this.availableStock = availableStock;
        this.lockedStock = 0;
    }

    public String getProductId() {
        return productId;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void addStock(int quantity) {
        availableStock += quantity;
    }

    public void lockStock(int quantity) throws IllegalArgumentException {
        if (quantity > availableStock) {
            throw new IllegalArgumentException("Not enough stock to lock.");
        }
        lockedStock += quantity;
    }

    public void unlockStock(int quantity) {
        if (quantity <= lockedStock) {
            lockedStock -= quantity;
        } else {
            throw new IllegalArgumentException("Cannot unlock more stock than locked.");
        }
    }

    public void reduceStock(int quantity) {
        if (quantity <= availableStock) {
            availableStock -= quantity;
        } else {
            throw new IllegalArgumentException("Not enough stock to reduce.");
        }
    }

    public int getLockedStock() {
        return lockedStock;
    }
}
