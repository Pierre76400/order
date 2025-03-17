package fr.kata.order.domain.model;

public class Product {
    private long idProduct;
    private String name;
    private double price;

    public Product(long idProduct, String name, double price) {
        this.idProduct = idProduct;
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

    public long getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
