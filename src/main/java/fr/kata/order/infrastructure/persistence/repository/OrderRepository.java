package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.CustomerEntity;
import fr.kata.order.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

    List<OrderEntity> findByCustomerEntity_idCustomer(long idCustomer);
}
