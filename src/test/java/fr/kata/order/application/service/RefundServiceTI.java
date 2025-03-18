package fr.kata.order.application.service;

import fr.kata.order.domain.model.OrderProduct;
import fr.kata.order.domain.model.Product;
import fr.kata.order.domain.repository.OrderProductRepository;
import fr.kata.order.domain.repository.RefundRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class RefundServiceTI {
    @Autowired
    private RefundService refundService;

    @Test
    void shouldCreateRefund() {
        refundService.createRefund(100l,1000L, 1000L);
    }

    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(100l,3000L, 2000L));
    }

}