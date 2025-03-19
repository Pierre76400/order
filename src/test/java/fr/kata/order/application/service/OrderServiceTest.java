package fr.kata.order.application.service;

import fr.kata.order.domain.model.*;
import fr.kata.order.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderRepository);
    }

    @Test
    void shouldReturnOrderHistory() {
        Product product1 = new Product(1, "Cuillere", 10.0);
        OrderProduct orderProduct1 = new OrderProduct(1l,product1, 2);

        Customer customer = new Customer(1, "John", "Doe");
        Order order = new Order(1, customer, LocalDate.now(), Arrays.asList(orderProduct1));

        LocalDate date = LocalDate.of(2025, 1, 1);
        when(orderRepository.getOrdersByCustomerIdAndDate(1000L, date)).thenReturn(List.of(order));

        var orderHistory = orderService.getOrderHistory(1000L, date);

        assertNotNull(orderHistory);
        assertEquals(1, orderHistory.size());
    }

    @Test
    void shouldNotAllowOrderHistoryMoreThanOneYear() {
        assertThrows(IllegalArgumentException.class, () ->  orderService.getOrderHistory(1000L, LocalDate.of(2019, 4, 18)));
    }

}