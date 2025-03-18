package fr.kata.order.domain.model;

public class OrderProduct {

    private long id;
    private Product product;
    private int quantity;

    public OrderProduct(long id,Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;

        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }


    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public long getId() {
        return id;
    }
}
