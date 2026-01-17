package com.research.model;

public class MenuCategory {
    private int id;
    private String name;
    private String description;

    public MenuCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Category{id=" + id + ", name='" + name + "'}";
    }
}
