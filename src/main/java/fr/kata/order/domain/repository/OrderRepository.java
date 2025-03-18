package fr.kata.order.domain.repository;

import fr.kata.order.domain.model.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository {
    List<Order> getOrdersByCustomerIdAndDate(Long customerId, Date date);
}
