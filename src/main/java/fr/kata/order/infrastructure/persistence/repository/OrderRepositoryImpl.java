package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.domain.model.*;
import fr.kata.order.domain.repository.OrderRepository;
import fr.kata.order.infrastructure.persistence.entity.OrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderEntityRepository orderRepository;

    public OrderRepositoryImpl(OrderEntityRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrdersByCustomerIdAndDate(Long customerId, Date date) {
        List<OrderEntity> orders = orderRepository.findByCustomerEntity_idCustomerAndDateOrderAfter(customerId, date);
        return orders.stream().map(ent->entityToDomain(ent)).toList();
    }

    private Order entityToDomain(OrderEntity orderEntity) {
        Customer customer = new Customer(orderEntity.getCustomerEntity().getIdCustomer(),
                orderEntity.getCustomerEntity().getFirstName(),
                orderEntity.getCustomerEntity().getLastName());

        List< OrderProduct > orderProducts = orderEntity.getOrderProductsEntities().stream()
                .map(orderProductEntity -> new OrderProduct(orderProductEntity.getIdOrderProduct(),
                        new Product(orderProductEntity.getProduct().getNumProduct(),
                                orderProductEntity.getProduct().getName(),
                                orderProductEntity.getProduct().getPrice()),
                    orderProductEntity.getQuantity()))
                .toList();

        Order order = new Order(orderEntity.getNumOrder(),customer, orderEntity.getDateOrder(), orderProducts);

        return order;
    }
}
