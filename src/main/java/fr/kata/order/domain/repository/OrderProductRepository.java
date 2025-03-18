package fr.kata.order.domain.repository;

import fr.kata.order.domain.model.Order;
import fr.kata.order.domain.model.OrderProduct;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderProductRepository {
    Optional<OrderProduct> findOrderProductById(long numOrder, long numProduct);
}
