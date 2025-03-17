package fr.kata.order.domain.model;

public class Refund {
    private long numRefund;

    private OrderProduct orderProduct;

    public Refund(long numRefund, OrderProduct orderProduct) {
        this.numRefund = numRefund;
        this.orderProduct = orderProduct;

        if(orderProduct == null) {
            throw new IllegalArgumentException("Order product cannot be null");
        }
    }

    public long getNumRefund() {
        return numRefund;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }
}
