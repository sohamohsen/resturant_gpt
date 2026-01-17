package com.research.model;

import com.research.model.TableStatus;

public class Table {
    private int id;
    private int tableNumber;
    private int capacity;
    private TableStatus status = TableStatus.AVAILABLE;

    public Table(int id, int tableNumber, int capacity) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public int getCapacity() { return capacity; }
    public TableStatus getStatus() { return status; }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " (" + status + ")";
    }
}
