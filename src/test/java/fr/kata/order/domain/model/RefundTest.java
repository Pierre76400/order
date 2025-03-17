package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefundTest {

    @Test
    void shouldCreateRefundWithValidData() {
        Refund refund = new Refund(1, new OrderProduct(new Product(1, "Product 1", 10.0), 1));

        assertEquals(1, refund.getNumRefund());
        assertEquals(1, refund.getOrderProduct().getQuantity());

    }

    @Test
    void shouldNotAllowNullOrderProduct() {
        assertThrows(IllegalArgumentException.class, () -> new Refund(1, null));
    }
}