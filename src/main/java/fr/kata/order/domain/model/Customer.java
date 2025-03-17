package fr.kata.order.domain.model;

public class Customer {
    private long idCustomer;

    private String firstName;

    private String lastName;

    public Customer(long idCustomer, String firstName, String lastName) {
        this.idCustomer = idCustomer;
        this.firstName = firstName;
        this.lastName = lastName;

        if(firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
