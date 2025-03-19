package fr.kata.order.domain.repository;

import fr.kata.order.domain.model.OrderProduct;

import java.util.Optional;

public interface OrderProductRepository {
    Optional<OrderProduct> findOrderProductById(long numOrder, long numProduct);
}
