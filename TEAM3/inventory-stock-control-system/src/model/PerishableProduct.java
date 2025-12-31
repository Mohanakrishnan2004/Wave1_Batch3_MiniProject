package model;

import java.time.LocalDate;

import exception.ExpiredProductException;
import exception.InsufficientStockException;

public class PerishableProduct extends Product {

    private LocalDate expiryDate;

    public PerishableProduct(int productId, String name, String category,
                              int stockQuantity, int reorderLevel,
                              LocalDate expiryDate) {
        super(productId, name, category, stockQuantity, reorderLevel);
        this.expiryDate = expiryDate;
    }

    @Override
    public void removeStock(int qty) throws InsufficientStockException {
        if (expiryDate.isBefore(LocalDate.now())) {
            throw new ExpiredProductException("Product is expired");
        }
        super.removeStock(qty);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
