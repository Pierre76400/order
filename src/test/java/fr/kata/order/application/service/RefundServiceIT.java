package fr.kata.order.application.service;

import fr.kata.order.infrastructure.persistence.entity.RefundEntity;
import fr.kata.order.infrastructure.persistence.repository.RefundEntityRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class RefundServiceIT {
    @Autowired
    private RefundService refundService;

    @Autowired
    private RefundEntityRepository refundEntityRepository;

    @Test
    void shouldCreateRefund() {
        int nbRefunds = refundEntityRepository.findAll().size();
        refundService.createRefund(100L,1000L, 1000L,"Produit cassé","preuve.jpg");

        List<RefundEntity> refundEntities = refundEntityRepository.findAll();

        assertEquals(1, refundEntities.size()-nbRefunds);
    }

    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(100L,3000L, 2000L,"Produit cassé","preuve.jpg"));
    }

}