package com.research.model;

public class Staff {
    private int id;
    private String fullName;
    private String role;
    private String email;
    private String phone;

    public Staff(int id, String fullName, String role, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getRole() { return role; }
    public String getFullName() { return fullName; }

    public void update(String fullName, String role, String email, String phone) {
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Staff{id=" + id + ", name='" + fullName + "', role='" + role + "'}";
    }
}
