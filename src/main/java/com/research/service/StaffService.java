package com.research.service;

import com.research.exception.EntityNotFoundException;
import com.research.model.Staff;
import com.research.repository.BaseRepository;
import com.research.util.ValidationUtil;

import java.util.List;
import java.util.stream.Collectors;

public class StaffService {

    private final BaseRepository<Staff> repository = new BaseRepository<>();

    public void add(int id, String name, String role, String email, String phone) {
        ValidationUtil.requirePositive(id, "Staff ID");
        ValidationUtil.requireNotBlank(name, "Staff Name");
        ValidationUtil.requireNotBlank(role, "Staff Role");

        repository.save(id, new Staff(id, name, role, email, phone));
    }

    public List<Staff> getAll() {
        return repository.findAll();
    }

    public Staff getById(int id) {
        Staff staff = repository.findById(id);
        if (staff == null)
            throw new EntityNotFoundException("Staff not found");
        return staff;
    }

    public void update(int id, String name, String role, String email, String phone) {
        Staff staff = getById(id);
        ValidationUtil.requireNotBlank(name, "Staff Name");
        ValidationUtil.requireNotBlank(role, "Staff Role");
        staff.update(name, role, email, phone);
    }

    public void delete(int id) {
        getById(id);
        repository.delete(id);
    }

    public List<Staff> search(String keyword) {
        return repository.findAll().stream()
                .filter(s -> s.getFullName().toLowerCase().contains(keyword.toLowerCase())
                        || s.getRole().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
