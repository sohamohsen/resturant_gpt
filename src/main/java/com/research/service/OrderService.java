package com.research.service;

import com.research.exception.BusinessRuleException;
import com.research.model.Customer;
import com.research.model.MenuItem;
import com.research.model.Order;
import com.research.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {

    private static final double SERVICE_CHARGE = 0.10;

    public Order createOrder(int id, Customer customer, List<MenuItem> items) {

        if (items == null || items.isEmpty())
            throw new BusinessRuleException("Order must contain items");

        double total = items.stream()
                .filter(MenuItem::isAvailable)
                .mapToDouble(MenuItem::getPrice)
                .sum();

        total += total * SERVICE_CHARGE;
        customer.addPoints((int) total);

        return new Order(id, customer, items,
                total, OrderStatus.PENDING, LocalDateTime.now());
    }
}
