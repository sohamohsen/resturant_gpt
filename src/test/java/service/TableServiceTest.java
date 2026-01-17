package service;

import com.research.service.TableService;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Table Management")
class TableServiceTest {

    private TableService service;

    @BeforeEach
    void setUp() {
        service = new TableService();
    }

    @Test
    @Story("Add table")
    void addTable_success() {
        service.add(1, 10, 4);
        assertEquals(1, service.getAll().size());
    }

    @Test
    @Story("Get available tables")
    void getAvailableTables_success() {
        service.add(1, 10, 4);
         service.add(2, 11, 6);

        assertEquals(2, service.getAvailableTables().size());
    }

    @Test
    @Story("Wrong available tables count")
    void wrongAvailableCount_fail() {
        service.add(1, 10, 4);
        assertEquals(0, service.getAvailableTables().size());
    }
}
