package service;

import com.research.exception.EntityNotFoundException;
import com.research.service.StaffService;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Staff Management")
class StaffServiceTest {

    private StaffService staffService;

    @BeforeEach
    void setUp() {
        staffService = new StaffService();
    }

    @Test
    @Story("Add staff successfully")
    @Severity(SeverityLevel.CRITICAL)
    void addStaff_success() {
        staffService.add(1, "Ahmed Ali", "Chef", "a@x.com", "010");

        assertEquals(1, staffService.getAll().size());
    }

    @Test
    @Story("Add staff with invalid ID")
    @Severity(SeverityLevel.NORMAL)
    void addStaff_invalidId_shouldFail() {
        assertThrows(IllegalArgumentException.class, () ->
                staffService.add(0, "Ahmed", "Chef", "a@x.com", "010")
        );
    }

    @Test
    @Story("Wrong expectation – human error")
    @Severity(SeverityLevel.MINOR)
    void addStaff_wrongExpectation_fail() {
        staffService.add(1, "Ahmed Ali", "Chef", "a@x.com", "010");

        assertEquals(2, staffService.getAll().size(),
                "Developer assumed 2 records but only 1 exists");
    }

    @Test
    @Story("Get staff not found")
    void getStaff_notFound() {
        assertThrows(EntityNotFoundException.class, () ->
                staffService.getById(99)
        );
    }
}
