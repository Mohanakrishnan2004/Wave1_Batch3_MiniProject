package model;


public class NonPerishableProduct extends Product {

    public NonPerishableProduct(int productId, String name, String category,
                                int stockQuantity, int reorderLevel) {
        super(productId, name, category, stockQuantity, reorderLevel);
    }
}
