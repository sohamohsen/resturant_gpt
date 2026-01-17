package com.research.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private int id;
    private Customer customer;
    private RestaurantTable table;
    private LocalDate date;
    private LocalTime time;
    private int guests;

    public Reservation(int id, Customer customer, RestaurantTable table,
                       LocalDate date, LocalTime time, int guests) {
        this.id = id;
        this.customer = customer;
        this.table = table;
        this.date = date;
        this.time = time;
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "Reservation{id=" + id + ", table=" + table + ", guests=" + guests + "}";
    }
}
