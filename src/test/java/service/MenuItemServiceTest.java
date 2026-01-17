package service;

import com.research.exception.BusinessRuleException;
import com.research.model.MenuCategory;
import com.research.service.MenuItemService;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Menu Item Management")
class MenuItemServiceTest {

    private MenuItemService service;
    private MenuCategory category;

    @BeforeEach
    void setUp() {
        service = new MenuItemService();
        category = new MenuCategory(1, "Food", "Food");
    }

    @Test
    @Story("Add menu item successfully")
    void addMenuItem_success() {
        service.add(1, "Pizza", "Cheese", 80, category);
        assertEquals(1, service.getAll().size());
    }

    @Test
    @Story("Negative price should fail")
    void addMenuItem_negativePrice_fail() {
        assertThrows(BusinessRuleException.class, () ->
                service.add(1, "Pizza", "Cheese", -10, category)
        );
    }

    @Test
    @Story("Search menu item with wrong expectation")
    void searchWrongExpectation_fail() {
        service.add(1, "Pizza", "Cheese", 80, category);
        assertEquals(0, service.search("Pizza").size());
    }
}
