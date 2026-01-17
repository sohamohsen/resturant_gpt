package service;

import com.research.exception.EntityNotFoundException;
import com.research.service.MenuCategoryService;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Menu Category Management")
class MenuCategoryServiceTest {

    private MenuCategoryService service;

    @BeforeEach
    void setUp() {
        service = new MenuCategoryService();
    }

    @Test
    @Story("Add category successfully")
    void addCategory_success() {
        service.add(1, "Drinks", "Cold drinks");
        assertEquals(1, service.getAll().size());
    }

    @Test
    @Story("Delete non-existing category")
    void deleteCategory_notFound_fail() {
        assertThrows(EntityNotFoundException.class, () ->
                service.delete(99)
        );
    }

    @Test
    @Story("Wrong assumption about categories count")
    void wrongCategoryCount_fail() {
        service.add(1, "Food", "Main food");
        assertEquals(2, service.getAll().size());
    }
}
