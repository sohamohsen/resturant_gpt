package com.research.model;

public class Customer {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private int loyaltyPoints;

    public Customer(int id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }

    public void addPoints(int points) {
        this.loyaltyPoints += points;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + fullName + "', points=" + loyaltyPoints + "}";
    }
}
