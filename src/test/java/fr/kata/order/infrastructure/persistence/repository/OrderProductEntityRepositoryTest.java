package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.OrderProductEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderProductEntityRepositoryTest {

    @Autowired
    private OrderProductEntityRepository orderProductEntityRepository;

    @Test
    void findByOrderEntity_idOrderAndProductEntity_idProduct() {
        Optional<OrderProductEntity> ope = orderProductEntityRepository.findByOrderEntity_NumOrderAndProduct_NumProduct(1000L,1002L);

        assertNotNull(ope);
        assertTrue(ope.isPresent());
    }
}