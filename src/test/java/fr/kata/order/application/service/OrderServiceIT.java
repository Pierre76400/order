package fr.kata.order.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceIT {

    @Autowired
    private OrderService orderService;

    @Test
    void shouldReturnOrderHistory() {
        LocalDate date = LocalDate.of(2024, 4, 18);

        var orderHistory = orderService.getOrderHistory(1000L, date);

        assertNotNull(orderHistory);
        assertEquals(1, orderHistory.size());
    }

    @Test
    void shouldNotAllowOrderHistoryMoreThanOneYear() {
        assertThrows(IllegalArgumentException.class, () ->  orderService.getOrderHistory(1000L, LocalDate.of(2019, 4, 18)));
    }

}