package com.research;

import com.research.service.*;
import com.research.ui.MainMenu;

public class Main {

    public static void main(String[] args) {

        StaffService staffService = new StaffService();
        MenuCategoryService categoryService = new MenuCategoryService();
        MenuItemService menuItemService = new MenuItemService();
        CustomerService customerService = new CustomerService();
        TableService tableService = new TableService();
        OrderService orderService = new OrderService();
        ReservationService reservationService = new ReservationService();

        // ✅ Create MainMenu object
        MainMenu mainMenu = new MainMenu(
                staffService,
                categoryService,
                menuItemService,
                customerService,
                tableService,
                orderService,
                reservationService
        );

        mainMenu.start();
    }
}
