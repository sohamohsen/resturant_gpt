package com.research.service;

import com.research.exception.EntityNotFoundException;
import com.research.model.MenuCategory;
import com.research.repository.BaseRepository;
import com.research.util.ValidationUtil;

import java.util.List;

public class MenuCategoryService {

    private final BaseRepository<MenuCategory> repository = new BaseRepository<>();

    public void add(int id, String name, String description) {
        ValidationUtil.requirePositive(id, "Category ID");
        ValidationUtil.requireNotBlank(name, "Category Name");

        repository.save(id, new MenuCategory(id, name, description));
    }

    public List<MenuCategory> getAll() {
        return repository.findAll();
    }

    public MenuCategory getById(int id) {
        MenuCategory category = repository.findById(id);
        if (category == null)
            throw new EntityNotFoundException("Category not found");
        return category;
    }

    public void delete(int id) {
        getById(id);
        repository.delete(id);
    }
}
