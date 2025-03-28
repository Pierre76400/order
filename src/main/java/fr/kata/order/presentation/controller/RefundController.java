package fr.kata.order.presentation.controller;

import fr.kata.order.application.service.RefundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/{numOrder}/refunds")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping
    public ResponseEntity createRefund(@PathVariable long numOrder,@RequestParam long numRefund,@RequestParam long numProduct) {
        refundService.createRefund(numRefund,numOrder,numProduct,null,null);
        return ResponseEntity.created(null).build();
    }
}