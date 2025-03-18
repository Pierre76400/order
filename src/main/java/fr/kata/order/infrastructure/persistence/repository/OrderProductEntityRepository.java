package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderProductEntityRepository extends JpaRepository<OrderProductEntity, Long> {

    Optional<OrderProductEntity> findByOrderEntity_NumOrderAndProduct_NumProduct(Long numOrder, Long numProduct);

}
