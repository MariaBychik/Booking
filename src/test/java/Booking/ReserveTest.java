package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReserveTest extends BaseTest {

    @Test
    // Reserve stays with valid values without authorization in the account
    public void booking() throws Exception {
        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie()
                .selectDestination(getTestData().getDestinationReserve())
                .clickArrive()
                .selectArriveData(getTestData().getExpArriveMonthReserve(), getTestData().getExpArriveDateReserve())
                .selectDepartureData(getTestData().getExpDepartureMonthReserve(), getTestData().getExpDepartureDateReserve())
                .runSearch()
                .selectResults()
                .switchTab()
                .selectRoomQuantity(getTestData().getExpCountReserveRoom())
                .confirmReservation()
                .fillInFirstNameData(getTestData().getFirstName())
                .fillInLastNameData(getTestData().getLastName())
                .fillInEmail(getTestData().getEmail())
                .confirmEmail(getTestData().getEmail())
                .selectBookingAim()
                .clickBookButton()
                .fillInPhoneNumber(getTestData().getPhoneNumber())
                .completeBooking();
        Assert.assertTrue(bookWithoutCard.isReservationConfirmed(), "Reservation is failed");
    }
}





