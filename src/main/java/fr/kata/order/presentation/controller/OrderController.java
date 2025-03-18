package fr.kata.order.presentation.controller;


import fr.kata.order.application.dto.OrderDto;
import fr.kata.order.application.service.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrderHistory(@RequestParam long customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate orderDate) {
        Date date = Date.from(orderDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<OrderDto> orders = orderService.getOrderHistory(customerId, date);
        return ResponseEntity.ok(orders);
    }
}