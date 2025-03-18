package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.CustomerEntity;
import fr.kata.order.infrastructure.persistence.entity.OrderEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderRepositoryTest {


    @Autowired
    private OrderRepository orderRepository;


    @Test
    void findByCustomer() {
        List<OrderEntity> orders = orderRepository.findByCustomerEntity_idCustomer(1000l);

        assertNotNull(orders);
        assertEquals(2,orders.size());
    }


    @Test
    void findAll() {
        List<OrderEntity> orders = orderRepository.findAll();

        assertNotNull(orders);
        assertEquals(3,orders.size());
    }
}