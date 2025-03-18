package fr.kata.order.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
public class RefundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRefund;

    private long numRefund;

    private String picture;

    private String description;

    @ManyToOne
    private OrderProductEntity orderProductEntity;

    public Long getIdRefund() {
        return idRefund;
    }

    public void setIdRefund(Long idRefund) {
        this.idRefund = idRefund;
    }

    public long getNumRefund() {
        return numRefund;
    }

    public void setNumRefund(long numRefund) {
        this.numRefund = numRefund;
    }

    public OrderProductEntity getOrderProductEntity() {
        return orderProductEntity;
    }

    public void setOrderProductEntity(OrderProductEntity orderProductEntity) {
        this.orderProductEntity = orderProductEntity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
