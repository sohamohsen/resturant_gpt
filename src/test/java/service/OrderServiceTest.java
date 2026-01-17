package service;

import com.research.exception.BusinessRuleException;
import com.research.model.Customer;
import com.research.model.MenuItem;
import com.research.model.MenuCategory;
import com.research.service.OrderService;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Order Management")
class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    @Story("Create valid order")
    @Severity(SeverityLevel.BLOCKER)
    void createOrder_success() {
        Customer customer = Mockito.mock(Customer.class);

        MenuCategory cat = new MenuCategory(1, "Food", "Food");
        MenuItem item = new MenuItem(1, "Burger", "Beef", 100, cat);

        var order = orderService.createOrder(1, customer, List.of(item));

        assertNotNull(order);
    }

    @Test
    @Story("Empty order should fail")
    void createOrder_emptyItems_fail() {
        Customer customer = Mockito.mock(Customer.class);

        assertThrows(BusinessRuleException.class, () ->
                orderService.createOrder(1, customer, List.of())
        );
    }

    @Test
    @Story("Wrong total calculation")
    void wrongTotalCalculation_fail() {
        Customer customer = Mockito.mock(Customer.class);

        MenuCategory cat = new MenuCategory(1, "Food", "Food");
        MenuItem item = new MenuItem(1, "Burger", "Beef", 100, cat);

        var order = orderService.createOrder(1, customer, List.of(item));

        assertEquals(100, order.toString().contains("100"));
    }
}
