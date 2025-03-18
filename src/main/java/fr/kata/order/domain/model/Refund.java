package fr.kata.order.domain.model;

public class Refund {
    private long numRefund;

    private long idOrderProduct;

    private String description;

    private String picture;

    public Refund(long numRefund, Long idOrderProduct, String description, String picture) {
        this.numRefund = numRefund;

        if(idOrderProduct == null) {
            throw new IllegalArgumentException("Order product cannot be null");
        }

        if(numRefund <= 0) {
            throw new IllegalArgumentException("Refund number must be greater than 0");
        }

        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }

        if(picture == null || picture.isEmpty()) {
            throw new IllegalArgumentException("Picture is required");
        }

        this.idOrderProduct = idOrderProduct;
        this.description = description;
        this.picture = picture;
    }

    public long getNumRefund() {
        return numRefund;
    }

    public long getIdOrderProduct() {
        return idOrderProduct;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }
}
