package com.research.service;

import com.research.exception.EntityNotFoundException;
import com.research.model.Customer;
import com.research.repository.BaseRepository;
import com.research.util.ValidationUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private final BaseRepository<Customer> repository = new BaseRepository<>();

    public void add(int id, String name, String email, String phone) {
        ValidationUtil.requirePositive(id, "Customer ID");
        ValidationUtil.requireNotBlank(name, "Customer Name");

        repository.save(id, new Customer(id, name, email, phone));
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getById(int id) {
        Customer customer = repository.findById(id);
        if (customer == null)
            throw new EntityNotFoundException("Customer not found");
        return customer;
    }

    public void delete(int id) {
        getById(id);
        repository.delete(id);
    }

    public List<Customer> search(String keyword) {
        return repository.findAll().stream()
                .filter(c -> c.toString().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
