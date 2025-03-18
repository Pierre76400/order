package fr.kata.order.presentation.controller;


import fr.kata.order.application.dto.OrderDto;
import fr.kata.order.application.service.OrderService;
import fr.kata.order.application.service.RefundService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders/{numOrder}/refunds")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping
    public ResponseEntity createRefund(@PathVariable long numOrder,@RequestParam long numRefund,@RequestParam long numProduct) {
        refundService.createRefund(numRefund,numOrder,numProduct);
        return ResponseEntity.created(null).build();
    }
}