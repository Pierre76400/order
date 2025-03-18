package fr.kata.order.application.service;

import fr.kata.order.domain.model.OrderProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService=new OrderService();

    @Test
    void shouldReturnOrderHistory() {
        var orderHistory = orderService.getOrderHistory(1000L, new Date(2025, 1, 1));

        assertNotNull(orderHistory);
        assertEquals(2, orderHistory.size());
    }


    @Test
    void shouldNotAllowOrderHistoryMoreThanOneYear() {
        assertThrows(IllegalArgumentException.class, () ->  orderService.getOrderHistory(1000L, new Date(2025, 1, 1)));
    }

}