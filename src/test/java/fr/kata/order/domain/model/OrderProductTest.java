package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderProductTest {

    @Test
    void shouldCreateOrderProductWithValidData() {
        Product product = new Product(1, "Product 1", 10.0);
        OrderProduct orderProduct = new OrderProduct(1l,product, 2);

        assertEquals(product, orderProduct.getProduct());
        assertEquals(2, orderProduct.getQuantity());
    }

    @Test
    void shouldNotAllowNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> new OrderProduct(1l,null, 2));
    }

    @Test
    void shouldNotAllowNegativeQuantity() {
        Product product = new Product(1, "Product 1", 10.0);
        assertThrows(IllegalArgumentException.class, () -> new OrderProduct(1l,product, -2));
    }

    @Test
    void shouldNotAllowZeroQuantity() {
        Product product = new Product(1, "Product 1", 10.0);
        assertThrows(IllegalArgumentException.class, () -> new OrderProduct(1l,product, 0));
    }


    @Test
    void shouldCalculateTotalPrice() {
        Product product = new Product(1, "Product 1", 10.0);
        OrderProduct orderProduct = new OrderProduct(1l,product, 2);

        assertEquals(20.0, orderProduct.getTotalPrice());
    }
}