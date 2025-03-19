package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.domain.model.Refund;
import fr.kata.order.infrastructure.persistence.entity.OrderProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RefundRepositoryImplTest {

    private RefundRepositoryImpl refundRepositoryImpl;

    @Mock
    private RefundEntityRepository refundEntityRepository;

    @Mock
    private OrderProductEntityRepository orderProductEntityRepository;


    @BeforeEach
    void setUp() {
        refundRepositoryImpl = new RefundRepositoryImpl(refundEntityRepository, orderProductEntityRepository);
    }

    @Test
    void shouldCreateRefund() {
        Refund refund = new Refund(1, 1001L, "Produit cassé", "preuve.jpg");

        when(orderProductEntityRepository.findById(1001L)).thenReturn(Optional.of(new OrderProductEntity()));

        refundRepositoryImpl.createRefund(refund);
    }


    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        Refund refund = new Refund(1, 1001L, "Produit cassé", "preuve.jpg");

        assertThrows(IllegalArgumentException.class, () -> refundRepositoryImpl.createRefund(refund));
    }

}