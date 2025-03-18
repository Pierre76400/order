package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long>{

    List<OrderEntity> findByCustomerEntity_idCustomer(long idCustomer);
}
