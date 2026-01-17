package com.research.service;

import com.research.exception.BusinessRuleException;
import com.research.exception.EntityNotFoundException;
import com.research.model.*;
import com.research.repository.BaseRepository;
import com.research.util.ValidationUtil;

import java.util.List;
import java.util.stream.Collectors;

public class MenuItemService {

    private final BaseRepository<MenuItem> repository = new BaseRepository<>();

    public void add(int id, String name, String description,
                    double price, MenuCategory category) {

        ValidationUtil.requirePositive(id, "Menu Item ID");
        ValidationUtil.requireNotBlank(name, "Menu Item Name");

        if (price < 0)
            throw new BusinessRuleException("Price cannot be negative");

        repository.save(id, new MenuItem(id, name, description, price, category));
    }

    public List<MenuItem> getAll() {
        return repository.findAll();
    }

    public MenuItem getById(int id) {
        MenuItem item = repository.findById(id);
        if (item == null)
            throw new EntityNotFoundException("Menu item not found");
        return item;
    }

    public void delete(int id) {
        getById(id);
        repository.delete(id);
    }

    public List<MenuItem> search(String keyword) {
        return repository.findAll().stream()
                .filter(i -> i.toString().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
