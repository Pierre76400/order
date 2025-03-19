package fr.kata.order.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefundTest {

    @Test
    void shouldCreateRefundWithValidData() {
        Refund refund = new Refund(1, 1001L, "Produit cassé", "preuve.jpg");

        assertEquals(1, refund.getNumRefund());
        assertEquals(1001L, refund.getIdOrderProduct());

    }

    @Test
    void shouldNotAllowNullOrderProduct() {
        assertThrows(IllegalArgumentException.class, () -> new Refund(1, null, "Produit cassé", "preuve.jpg"));
    }

    @Test
    void shouldNotAllowRefundNumberLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> new Refund(0, 1001L, "Produit cassé", "preuve.jpg"));
    }

    @Test
    void shouldNotAllowEmptyDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Refund(1, 1001L, "", "preuve.jpg"));
    }

    @Test
    void shouldNotAllowEmptyPicture() {
        assertThrows(IllegalArgumentException.class, () -> new Refund(1, 1001L, "Produit cassé", ""));
    }
}