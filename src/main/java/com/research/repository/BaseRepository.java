package com.research.repository;

import com.research.exception.DuplicateIdException;

import java.util.*;

public class BaseRepository<T> {

    protected Map<Integer, T> storage = new HashMap<>();

    public void save(int id, T entity) {
        if (storage.containsKey(id))
            throw new DuplicateIdException("Duplicate ID.");
        storage.put(id, entity);
    }

    public T findById(int id) {
        return storage.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(int id) {
        storage.remove(id);
    }
}
