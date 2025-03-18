package fr.kata.order.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RefundServiceTest {

    @InjectMocks
    private RefundService refundService=new RefundService();

    @Test
    void shouldCreateRefund() {
        var refund = refundService.createRefund(1000L, 1000L, 1000L);

        assertNotNull(refund);
        assertEquals(1000L, refund.getId());
        assertEquals("Jean DUPONT", refund.getCustomerName());
        assertEquals("Assiette", refund.getProductName());
    }

    @Test
    void shoudThrowExceptionWhenOrderNotFound() {
        assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(1000L, 2000L, 3000L));
    }

}