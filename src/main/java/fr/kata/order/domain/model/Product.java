package fr.kata.order.domain.model;

public class Product {
    private long numProduct;
    private String name;
    private double price;

    public Product(long numProduct, String name, double price) {
        this.numProduct = numProduct;
        this.name = name;
        this.price = price;

        if(name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if(name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

    }

    public long getNumProduct() {
        return numProduct;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
