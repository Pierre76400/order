package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefundTest {

    @Test
    void shouldCreateRefundWithValidData() {
        Refund refund = new Refund(1, 1001l);

        assertEquals(1, refund.getNumRefund());
        assertEquals(1001l, refund.getIdOrderProduct());

    }

    @Test
    void shouldNotAllowNullOrderProduct() {
        assertThrows(IllegalArgumentException.class, () -> new Refund(1, null));
    }
}