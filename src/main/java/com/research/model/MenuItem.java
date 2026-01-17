package com.research.model;

public class MenuItem {
    private int id;
    private String name;
    private String description;
    private double price;
    private MenuCategory category;
    private boolean available = true;

    public MenuItem(int id, String name, String description, double price, MenuCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public int getId() { return id; }
    public boolean isAvailable() { return available; }
    public double getPrice() { return price; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return name + " - $" + price + (available ? " ✔" : " ❌");
    }
}
