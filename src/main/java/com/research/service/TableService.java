package com.research.service;

import com.research.exception.EntityNotFoundException;
import com.research.model.RestaurantTable;
import com.research.repository.BaseRepository;
import com.research.util.ValidationUtil;

import java.util.List;
import java.util.stream.Collectors;

public class TableService {

    private final BaseRepository<RestaurantTable> repository = new BaseRepository<>();

    public void add(int id, int tableNumber, int capacity) {
        ValidationUtil.requirePositive(id, "Table ID");
        ValidationUtil.requirePositive(tableNumber, "Table Number");
        ValidationUtil.requirePositive(capacity, "Capacity");

        repository.save(id, new RestaurantTable(id, tableNumber, capacity));
    }

    public List<RestaurantTable> getAll() {
        return repository.findAll();
    }

    public RestaurantTable getById(int id) {
        RestaurantTable table = repository.findById(id);
        if (table == null)
            throw new EntityNotFoundException("Table not found");
        return table;
    }

    public List<RestaurantTable> getAvailableTables() {
        return repository.findAll().stream()
                .filter(RestaurantTable::isAvailable)
                .collect(Collectors.toList());
    }

    public void delete(int id) {
        getById(id);
        repository.delete(id);
    }
}
