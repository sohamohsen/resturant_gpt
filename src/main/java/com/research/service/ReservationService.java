package com.research.service;

import com.research.exception.BusinessRuleException;
import com.research.model.Customer;
import com.research.model.Reservation;
import com.research.model.RestaurantTable;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationService {

    public Reservation reserve(int id, Customer customer,
                               RestaurantTable table,
                               LocalDate date, LocalTime time,
                               int guests) {

        if (!table.isAvailable())
            throw new BusinessRuleException("Table not available");

        if (guests > table.getCapacity())
            throw new BusinessRuleException("Table capacity exceeded");

        table.reserve();
        return new Reservation(id, customer, table, date, time, guests);
    }
}
