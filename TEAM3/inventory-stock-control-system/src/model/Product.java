package model;

import exception.InsufficientStockException;

public class Product {

    private int productId;
    private String name;
    private String category;
    private int stockQuantity;
    private int reorderLevel;

    public Product(int productId, String name, String category,
                   int stockQuantity, int reorderLevel) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.reorderLevel = reorderLevel;
    }

    public void addStock(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.stockQuantity += qty;
    }

    public void removeStock(int qty) throws InsufficientStockException {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (qty > stockQuantity) {
            throw new InsufficientStockException("Not enough stock available");
        }
        this.stockQuantity -= qty;
    }

    public boolean isReorderNeeded() {
        return stockQuantity <= reorderLevel;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }
}
