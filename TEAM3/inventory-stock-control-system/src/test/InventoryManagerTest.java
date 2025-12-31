package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.ProductNotFoundException;
import model.NonPerishableProduct;
import model.Product;
import model.Supplier;
import service.InventoryManager;

public class InventoryManagerTest {

    @Test
    void testAddAndGetProduct() {
        InventoryManager manager = new InventoryManager();
        Product product = new NonPerishableProduct(10, "Pen", "Stationery", 50, 10);

        manager.addProduct(product);

        assertEquals("Pen", manager.getProduct(10).getName());
    }

    @Test
    void testReorderAlert() {
        InventoryManager manager = new InventoryManager();
        Product product = new NonPerishableProduct(11, "Notebook", "Stationery", 5, 10);

        manager.addProduct(product);

        assertTrue(manager.isReorderAlert(11));
    }

    @Test
    void testSupplierLinking() {
        InventoryManager manager = new InventoryManager();
        Product product = new NonPerishableProduct(12, "Mouse", "Electronics", 20, 5);
        Supplier supplier = new Supplier(101, "Tech Supplies", "9876543210");

        manager.addProduct(product);
        manager.linkSupplier(12, supplier);

        assertEquals("Tech Supplies", manager.getSupplier(12).getSupplierName());
    }

    @Test
    void testProductNotFoundException() {
        InventoryManager manager = new InventoryManager();

        assertThrows(ProductNotFoundException.class, () -> {
            manager.getProduct(99);
        });
    }
}
