package fr.kata.order.domain.model;

public class Refund {
    private long numRefund;

    private long idOrderProduct;

    public Refund(long numRefund, Long idOrderProduct) {
        this.numRefund = numRefund;

        if(idOrderProduct == null) {
            throw new IllegalArgumentException("Order product cannot be null");
        }
        this.idOrderProduct = idOrderProduct;
    }

    public long getNumRefund() {
        return numRefund;
    }

    public long getIdOrderProduct() {
        return idOrderProduct;
    }
}
