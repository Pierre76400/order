package fr.kata.order.application.service;


import fr.kata.order.domain.model.OrderProduct;
import fr.kata.order.domain.model.Refund;
import fr.kata.order.domain.repository.OrderProductRepository;
import fr.kata.order.domain.repository.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RefundService {

    private RefundRepository refundRepository;

    private OrderProductRepository orderProductRepository;

    public RefundService(RefundRepository refundRepository, OrderProductRepository orderProductRepository) {
        this.refundRepository = refundRepository;
        this.orderProductRepository = orderProductRepository;
    }
    public void createRefund(long numRefund,long numOrder, long numProduct, String description, String picture){

        Optional<OrderProduct> orderProduct = orderProductRepository.findOrderProductById(numOrder, numProduct);

        if(orderProduct.isEmpty()){
            throw new IllegalArgumentException("Order product not found");
        }

        Refund refund = new Refund(numRefund, orderProduct.get().getId());

        refundRepository.createRefund(refund);

    }
}
