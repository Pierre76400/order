package fr.kata.order.application.service;

import fr.kata.order.domain.model.Customer;
import fr.kata.order.domain.model.Order;
import fr.kata.order.domain.model.OrderProduct;
import fr.kata.order.domain.model.Product;
import fr.kata.order.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceTI {

    @Autowired
    private OrderService orderService;

    @Test
    void shouldReturnOrderHistory() {
        LocalDateTime dateTime =LocalDateTime.of(2024, 4, 18, 0, 0, 0, 0);
        Date date =  Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        var orderHistory = orderService.getOrderHistory(1000L, date);

        assertNotNull(orderHistory);
        assertEquals(1, orderHistory.size());
    }

    @Test
    void shouldNotAllowOrderHistoryMoreThanOneYear() {
        assertThrows(IllegalArgumentException.class, () ->  orderService.getOrderHistory(1000L, new Date(20, 1, 1)));
    }

}