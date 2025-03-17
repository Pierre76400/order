package fr.kata.order.domain.model;

import java.util.Date;
import java.util.List;

public class Order {
    private long numOrder;

    private Customer customer;

    private Date dateOrder;

    private List<OrderProduct> orderProducts;

    public Order(long numOrder, Customer customer, Date dateOrder, List<OrderProduct> orderProducts) {
        this.numOrder = numOrder;
        this.customer = customer;
        this.dateOrder = dateOrder;
        this.orderProducts = orderProducts;

        if(customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        if(dateOrder == null) {
            throw new IllegalArgumentException("Date order cannot be null");
        }

        if(orderProducts == null) {
            throw new IllegalArgumentException("Order products cannot be null");
        }

        if(orderProducts.isEmpty()) {
            throw new IllegalArgumentException("Order products cannot be empty");
        }
    }

    public long getNumOrder() {
        return numOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public double getTotalPrice() {
        return orderProducts.stream().mapToDouble(OrderProduct::getTotalPrice).sum();
    }
}
