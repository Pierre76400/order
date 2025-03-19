package fr.kata.order.domain.repository;

import fr.kata.order.domain.model.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository {
    List<Order> getOrdersByCustomerIdAndDate(Long customerId, LocalDate date);
}
