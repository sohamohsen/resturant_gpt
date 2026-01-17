package service;

import com.research.exception.BusinessRuleException;
import com.research.model.Customer;
import com.research.model.RestaurantTable;
import com.research.service.ReservationService;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Service Layer")
@Feature("Reservation Management")
class ReservationServiceTest {

    private final ReservationService reservationService = new ReservationService();

    @Test
    @Story("Reserve available table")
    void reserve_success() {
        Customer customer = new Customer(1, "Sara", "s@x.com", "011");
        RestaurantTable table = new RestaurantTable(1, 10, 4);

        assertDoesNotThrow(() ->
                reservationService.reserve(
                        1,
                        customer,
                        table,
                        LocalDate.now(),
                        LocalTime.NOON,
                        2
                )
        );
    }

    @Test
    @Story("Reserve table exceeding capacity")
    void reserve_exceedCapacity_fail() {
        Customer customer = new Customer(1, "Sara", "s@x.com", "011");
        RestaurantTable table = new RestaurantTable(1, 10, 2);

        assertThrows(BusinessRuleException.class, () ->
                reservationService.reserve(
                        1,
                        customer,
                        table,
                        LocalDate.now(),
                        LocalTime.NOON,
                        5
                )
        );
    }
}
