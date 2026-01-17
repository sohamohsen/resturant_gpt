package com.research.ui;

import com.research.service.*;

import java.util.Scanner;

public class MainMenu {

    private final StaffService staffService;
    private final MenuCategoryService categoryService;
    private final MenuItemService menuItemService;
    private final CustomerService customerService;
    private final TableService tableService;
    private final OrderService orderService;
    private final ReservationService reservationService;

    private final Scanner scanner = new Scanner(System.in);

    // ✅ SINGLE constructor – Dependency Injection
    public MainMenu(
            StaffService staffService,
            MenuCategoryService categoryService,
            MenuItemService menuItemService,
            CustomerService customerService,
            TableService tableService,
            OrderService orderService,
            ReservationService reservationService
    ) {
        this.staffService = staffService;
        this.categoryService = categoryService;
        this.menuItemService = menuItemService;
        this.customerService = customerService;
        this.tableService = tableService;
        this.orderService = orderService;
        this.reservationService = reservationService;
    }

    // ✅ Main UI loop
    public void start() {
        int choice;

        do {
            printMainMenu();
            choice = readInt("Choose option: ");

            switch (choice) {
                case 1 -> staffMenu();
                case 2 -> menuCategoryMenu();
                case 3 -> menuItemMenu();
                case 4 -> customerMenu();
                case 5 -> tableMenu();
                case 6 -> orderMenu();
                case 7 -> reservationMenu();
                case 0 -> System.out.println("System closed safely.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // ================= MENU PRINT =================

    private void printMainMenu() {
        System.out.println("""
            ===== Restaurant Management System =====
            1. Staff Management
            2. Menu Categories
            3. Menu Items
            4. Customers
            5. Tables
            6. Orders
            7. Reservations
            0. Exit
            """);
    }

    // ================= STAFF =================

    private void staffMenu() {
        System.out.println("""
            --- Staff Management ---
            1. Add Staff
            2. View All Staff
            0. Back
            """);

        int choice = readInt("Choose: ");
        switch (choice) {
            case 1 -> addStaff();
            case 2 -> staffService.getAll().forEach(System.out::println);
        }
    }

    private void addStaff() {
        int id = readInt("ID: ");
        String name = readString("Name: ");
        String role = readString("Role: ");
        String email = readString("Email: ");
        String phone = readString("Phone: ");

        try {
            staffService.add(id, name, role, email, phone);
            System.out.println("Staff added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= CATEGORY =================

    private void menuCategoryMenu() {
        System.out.println("""
            --- Menu Categories ---
            1. Add Category
            2. View Categories
            0. Back
            """);

        int choice = readInt("Choose: ");
        if (choice == 1) {
            int id = readInt("ID: ");
            String name = readString("Name: ");
            String desc = readString("Description: ");

            try {
                categoryService.add(id, name, desc);
                System.out.println("Category added.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (choice == 2) {
            categoryService.getAll().forEach(System.out::println);
        }
    }

    // ================= MENU ITEM =================

    private void menuItemMenu() {
        System.out.println("Menu Item module coming next...");
    }

    // ================= CUSTOMER =================

    private void customerMenu() {
        System.out.println("Customer module coming next...");
    }

    // ================= TABLE =================

    private void tableMenu() {
        System.out.println("Table module coming next...");
    }

    // ================= ORDER =================

    private void orderMenu() {
        System.out.println("Order module coming next...");
    }

    // ================= RESERVATION =================

    private void reservationMenu() {
        System.out.println("Reservation module coming next...");
    }

    // ================= INPUT HELPERS =================

    private int readInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    private String readString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}
