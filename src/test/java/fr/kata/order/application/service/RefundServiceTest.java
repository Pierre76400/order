package fr.kata.order.application.service;

import fr.kata.order.domain.model.OrderProduct;
import fr.kata.order.domain.model.Product;
import fr.kata.order.domain.repository.OrderProductRepository;
import fr.kata.order.domain.repository.RefundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RefundServiceTest {

    @Mock
    private RefundRepository refundRepository;

    @Mock
    private OrderProductRepository orderProductRepository;

    @InjectMocks
    private RefundService refundService;

    @BeforeEach
    void setUp() {
        refundService = new RefundService(refundRepository,orderProductRepository);
    }

    @Test
    void shouldCreateRefund() {
        Product product1 = new Product(1, "Cuillere", 10.0);
        when(orderProductRepository.findOrderProductById(1000L, 1000L)).thenReturn(Optional.of(new OrderProduct(1000L, product1,2)));


        refundService.createRefund(100l,1000L, 1000L,"Produit cassé","preuve.jpg");
    }

    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(100l,3000L, 2000L,"Produit cassé","preuve.jpg"));
    }


    @Test
    void shouldThrowExceptionWhenDescriptionIsEmpty() {
        Product product1 = new Product(1, "Cuillere", 10.0);
        when(orderProductRepository.findOrderProductById(1000L, 1000L)).thenReturn(Optional.of(new OrderProduct(1000L, product1,2)));

        assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(100l,1000L, 1000L,null,"preuve.jpg"));
    }


    @Test
    void shouldThrowExceptionWhenPictureIsEmpty() {
        Product product1 = new Product(1, "Cuillere", 10.0);
        when(orderProductRepository.findOrderProductById(1000L, 1000L)).thenReturn(Optional.of(new OrderProduct(1000L, product1,2)));

        assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(100l,1000L, 1000L,"Produit cassé",null));
    }

}