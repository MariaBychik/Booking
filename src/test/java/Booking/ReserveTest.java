package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReserveTest extends BaseTest {

    @Test
    // Reserve stays with valid values without authorization in the account
    public void booking() throws Exception {
        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie()
                .selectDestination(getTestData(15))
                .clickArrive()
                .selectArriveData(getTestData(16), getTestData(17))
                .selectDepartureData(getTestData(18), getTestData(19))
                .runSearch()
                .selectResults()
                .switchTab()
                .selectRoomQuantity(getTestData(20))
                .confirmReservation()
                .fillInFirstNameData(getTestData(21))
                .fillInLastNameData(getTestData(22))
                .fillInEmail(getTestData(23))
                .confirmEmail(getTestData(24))
                .selectBookingAim()
                .clickBookButton()
                .fillInPhoneNumber(getTestData(25))
                .completeBooking();
        Assert.assertTrue(bookWithoutCard.isReservationConfirmed(), "Reservation is failed");
    }
}





