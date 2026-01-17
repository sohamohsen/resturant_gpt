package com.research.model;

public class RestaurantTable {
    private int id;
    private int tableNumber;
    private int capacity;
    private TableStatus status = TableStatus.AVAILABLE;

    public RestaurantTable(int id, int tableNumber, int capacity) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return status == TableStatus.AVAILABLE;
    }

    public int getCapacity() { return capacity; }

    public void reserve() {
        status = TableStatus.RESERVED;
    }

    @Override
    public String toString() {
        return "Table #" + tableNumber + " (" + status + ")";
    }
}
