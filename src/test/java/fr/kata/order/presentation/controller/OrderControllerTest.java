package fr.kata.order.presentation.controller;

import fr.kata.order.application.dto.OrderDto;
import fr.kata.order.application.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
    @Mock
    private OrderService orderService;

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderController = new OrderController(orderService);
    }

    @Test
    void shouldReturnOrderHistory() {
        long customerId = 1L;
        LocalDate orderDate = LocalDate.now();
        List<OrderDto> orders = List.of(new OrderDto());

        when(orderService.getOrderHistory(customerId, orderDate)).thenReturn(orders);

        ResponseEntity<List<OrderDto>> response = orderController.getOrderHistory(customerId, orderDate);

        assertEquals(orders, response.getBody());
    }
}