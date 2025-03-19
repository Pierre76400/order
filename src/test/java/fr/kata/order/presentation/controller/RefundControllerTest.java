package fr.kata.order.presentation.controller;

import fr.kata.order.application.service.RefundService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RefundControllerTest {
    @Mock
    private RefundService refundService;

    private RefundController refundController;

    @BeforeEach
    void setUp() {
        refundController = new RefundController(refundService);
    }

    @Test
    void shouldCreateRefund() {
        long numOrder = 1L;
        long numRefund = 2L;
        long numProduct = 3L;
        ResponseEntity response = refundController.createRefund(numOrder, numRefund, numProduct);

        assertEquals(ResponseEntity.created(null).build(), response);
    }
}