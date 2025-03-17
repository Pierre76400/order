package fr.kata.order.domain.model;

public class OrderProduct {
    private Product product;
    private int quantity;

    public OrderProduct(Product product, int quantity) {
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
}
