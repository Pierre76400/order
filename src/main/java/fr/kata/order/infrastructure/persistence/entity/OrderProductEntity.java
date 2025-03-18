package fr.kata.order.infrastructure.persistence.entity;

import fr.kata.order.domain.model.Product;
import jakarta.persistence.*;

@Entity
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderProduct;

    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private OrderEntity orderEntity;

    private int quantity;

    public Long getIdOrderProduct() {
        return idOrderProduct;
    }


    public void setIdOrderProduct(Long idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
