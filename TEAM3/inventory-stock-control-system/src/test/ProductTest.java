package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.InsufficientStockException;
import model.Product;

public class ProductTest {

    @Test
    void testAddStock() {
        Product product = new Product(1, "Soap", "Hygiene", 10, 5);
        product.addStock(5);
        assertEquals(15, product.getStockQuantity());
    }

    @Test
    void testRemoveStock() {
        Product product = new Product(2, "Rice", "Grocery", 20, 5);
        product.removeStock(5);
        assertEquals(15, product.getStockQuantity());
    }

    @Test
    void testInsufficientStockException() {
        Product product = new Product(3, "Sugar", "Grocery", 5, 2);

        assertThrows(InsufficientStockException.class, () -> {
            product.removeStock(10);
        });
    }

    @Test
    void testReorderNeeded() {
        Product product = new Product(4, "Oil", "Grocery", 3, 5);
        assertTrue(product.isReorderNeeded());
    }
}
