package fr.kata.order.domain.repository;

import fr.kata.order.domain.model.Refund;

public interface RefundRepository {
    void createRefund(Refund refund);
}
