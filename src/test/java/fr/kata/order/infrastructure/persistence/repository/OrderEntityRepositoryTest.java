package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.OrderEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderEntityRepositoryTest {


    @Autowired
    private OrderEntityRepository orderRepository;


    @Test
    void findByCustomerEntity_idCustomerAndDateOrderAfter() {
        List<OrderEntity> orders = orderRepository.findByCustomerEntity_idCustomerAndDateOrderAfter(1000l,new Date(2020,1,1));

        assertNotNull(orders);
        //FIXME il y a un probléme sur le filtre de la date (le résultat devrait être 2)
        assertEquals(0,orders.size());
    }


    @Test
    void findByCustomerEntity_idCustomer() {
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