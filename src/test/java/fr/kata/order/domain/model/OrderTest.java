package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldCreateOrderWithValidData() {
        Product product1 = new Product(1, "Product 1", 10.0);
        OrderProduct orderProduct1 = new OrderProduct(product1, 2);

        Customer customer = new Customer(1, "John", "Doe");
        Order order = new Order(1, customer, new Date(), Arrays.asList(orderProduct1));

        assertEquals(1, order.getNumOrder());
        assertEquals(customer, order.getCustomer());
        assertNotNull(order.getDateOrder());
    }

    @Test
    void shouldNotAllowNullCustomer() {
        assertThrows(IllegalArgumentException.class, () -> new Order(1, null, new Date(), new ArrayList<>()));
    }

    @Test
    void shouldNotAllowNullDateOrder() {
        Customer customer = new Customer(1, "John", "Doe");
        assertThrows(IllegalArgumentException.class, () -> new Order(1, customer, null, new ArrayList<>()));
    }

    @Test
    void shouldNotAllowEmptyOrderProducts() {
        Customer customer = new Customer(1, "John", "Doe");
        assertThrows(IllegalArgumentException.class, () -> new Order(1, customer, new Date(), new ArrayList<>()));
    }

    @Test
    void shouldCalculateTotalPrice() {
        Product product1 = new Product(1, "Product 1", 10.0);
        Product product2 = new Product(2, "Product 2", 20.0);

        OrderProduct orderProduct1 = new OrderProduct(product1, 2);
        OrderProduct orderProduct2 = new OrderProduct(product2, 1);

        Customer customer = new Customer(1, "John", "Doe");

        Order order = new Order(1, customer, new Date(), Arrays.asList(orderProduct1, orderProduct2));


        assertEquals(40.0, order.getTotalPrice());
    }
}