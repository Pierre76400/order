package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.domain.model.OrderProduct;
import fr.kata.order.domain.model.Product;
import fr.kata.order.domain.repository.OrderProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class OrderProductRepositoryImpl implements OrderProductRepository {

    private final OrderProductEntityRepository orderProductEntityRepository;

    public OrderProductRepositoryImpl(OrderProductEntityRepository orderProductEntityRepository) {
        this.orderProductEntityRepository = orderProductEntityRepository;
    }


    @Override
    public Optional<OrderProduct> findOrderProductById(long numOrder, long numProduct) {

        return orderProductEntityRepository.findByOrderEntity_NumOrderAndProduct_NumProduct(numOrder, numProduct)
                .map(orderProductEntity -> new OrderProduct(orderProductEntity.getIdOrderProduct(),
                        new Product(orderProductEntity.getProduct().getNumProduct(),
                                orderProductEntity.getProduct().getName(),
                                orderProductEntity.getProduct().getPrice()),
                        orderProductEntity.getQuantity()));
    }
}
