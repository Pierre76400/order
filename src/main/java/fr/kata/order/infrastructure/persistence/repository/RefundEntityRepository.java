package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.RefundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundEntityRepository extends JpaRepository<RefundEntity, Long> {

}
