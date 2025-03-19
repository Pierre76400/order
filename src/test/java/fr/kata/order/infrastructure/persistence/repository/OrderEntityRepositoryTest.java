package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.OrderEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
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
        LocalDate date = LocalDate.of(2020,1,1);

        Date dateOrder =  Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<OrderEntity> orders = orderRepository.findByCustomerEntity_idCustomerAndDateOrderAfter(1000l,date);

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