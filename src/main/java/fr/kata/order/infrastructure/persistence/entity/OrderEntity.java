package fr.kata.order.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long numOrder;

    @ManyToOne
    private CustomerEntity customerEntity;

    private Date dateOrder;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderProductEntity> orderProductsEntities;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(long numOrder) {
        this.numOrder = numOrder;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public List<OrderProductEntity> getOrderProductsEntities() {
        return orderProductsEntities;
    }

    public void setOrderProductsEntities(List<OrderProductEntity> orderProductsEntities) {
        this.orderProductsEntities = orderProductsEntities;
    }
}
