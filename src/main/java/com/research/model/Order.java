package com.research.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<MenuItem> items;
    private double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;

    public Order(int id, Customer customer, List<MenuItem> items,
                 double totalAmount, OrderStatus status, LocalDateTime orderDate) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", total=$" + totalAmount + ", status=" + status + "}";
    }
}
