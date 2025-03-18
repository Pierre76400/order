package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long>{

}
