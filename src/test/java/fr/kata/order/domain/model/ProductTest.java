package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldCreateProductWithValidData() {
        Product product = new Product(1, "Product 1", 10.0);

        assertEquals(1, product.getNumProduct());
        assertEquals("Product 1", product.getName());
        assertEquals(10.0, product.getPrice());
    }

    @Test
    void shouldNotAllowNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Product(1, null, 10.0));
    }

    @Test
    void shouldNotAllowEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "", 10.0));
    }

    @Test
    void shouldNotAllowNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "Product 1", -10.0));
    }

    @Test
    void shouldNotAllowZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "Product 1", 0.0));
    }
}