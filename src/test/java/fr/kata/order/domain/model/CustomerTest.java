package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateCustomerWithValidData() {
        Customer customer = new Customer(1, "John", "Doe");

        assertEquals(1, customer.getIdCustomer());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
    }

    @Test
    void shouldNotAllowNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(1, null, "Doe"));
    }
}