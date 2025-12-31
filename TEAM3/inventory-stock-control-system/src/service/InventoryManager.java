package service;


import java.util.HashMap;
import java.util.Map;

import exception.ProductNotFoundException;
import model.Product;
import model.Supplier;

public class InventoryManager {

    // Store products using productId
    private Map<Integer, Product> inventory = new HashMap<>();

    // Store supplier for each product
    private Map<Integer, Supplier> supplierMap = new HashMap<>();

    /* ========================
       PRODUCT MANAGEMENT
       ======================== */

    // Add product to inventory
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Get product by ID
    public Product getProduct(int productId) {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found: " + productId);
        }
        return product;
    }

    // Increase stock
    public void addStock(int productId, int quantity) {
        Product product = getProduct(productId);
        product.addStock(quantity);
    }

    // Decrease stock (polymorphism applies here)
    public void removeStock(int productId, int quantity) {
        Product product = getProduct(productId);
        product.removeStock(quantity);
    }

    /* ========================
       REORDER & SUPPLIER LOGIC
       ======================== */

    // Check if reorder is needed
    public boolean isReorderAlert(int productId) {
        Product product = getProduct(productId);
        return product.isReorderNeeded();
    }

    // Link supplier to a product
    public void linkSupplier(int productId, Supplier supplier) {
        if (!inventory.containsKey(productId)) {
            throw new ProductNotFoundException("Cannot link supplier. Product not found.");
        }
        supplierMap.put(productId, supplier);
    }

    // Get supplier for a product
    public Supplier getSupplier(int productId) {
        Supplier supplier = supplierMap.get(productId);
        if (supplier == null) {
            throw new ProductNotFoundException("Supplier not found for product.");
        }
        return supplier;
    }

    /* ========================
       OPTIONAL HELPER METHOD
       ======================== */

    // View all products
    public Map<Integer, Product> getAllProducts() {
        return inventory;
    }
}

