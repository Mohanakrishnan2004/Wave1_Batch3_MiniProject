package test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exception.ExpiredProductException;
import model.PerishableProduct;

public class PerishableProductTest {

    @Test
    void testExpiredProductException() {
        PerishableProduct product = new PerishableProduct(
                5,
                "Milk",
                "Dairy",
                10,
                3,
                LocalDate.now().minusDays(1) // expired
        );

        assertThrows(ExpiredProductException.class, () -> {
            product.removeStock(1);
        });
    }
}
