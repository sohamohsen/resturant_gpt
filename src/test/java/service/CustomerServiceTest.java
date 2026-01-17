package service;

import com.research.exception.EntityNotFoundException;
import com.research.service.CustomerService;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Customer Management")
class CustomerServiceTest {

    private CustomerService service;

    @BeforeEach
    void setUp() {
        service = new CustomerService();
    }

    @Test
    @Story("Add customer")
    void addCustomer_success() {
        service.add(1, "Sara Ali", "s@x.com", "011");
        assertEquals(1, service.getAll().size());
    }

    @Test
    @Story("Search customer")
    void searchCustomer_success() {
        service.add(1, "Sara Ali", "s@x.com", "011");
        assertFalse(service.search("Sara").isEmpty());
    }

    @Test
    @Story("Delete customer wrong expectation")
    void deleteCustomer_fail() {
        service.add(1, "Sara Ali", "s@x.com", "011");
        service.delete(1);
        assertEquals(1, service.getAll().size());
    }

    @Test
    void getCustomer_notFound() {
        assertThrows(EntityNotFoundException.class, () ->
                service.getById(99)
        );
    }
}
