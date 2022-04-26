package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReserveTest extends BaseTest {

    @Test
    // Reserve stays with valid values without authorization in the account
    public void booking() throws Exception {
        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie()
                .selectDestination(getTestData("destinationReserve"))
                .clickArrive()
                .selectArriveData(getTestData("expArriveMonthReserve"), getTestData("expArriveDateReserve"))
                .selectDepartureData(getTestData("expDepartureMonthReserve"), getTestData("expDepartureDateReserve"))
                .runSearch()
                .selectResults()
                .switchTab()
                .selectRoomQuantity(getTestData("expCountReserveRoom"))
                .confirmReservation()
                .fillInFirstNameData(getTestData("firstName"))
                .fillInLastNameData(getTestData("lastName"))
                .fillInEmail(getTestData("email"))
                .confirmEmail(getTestData("email"))
                .selectBookingAim()
                .clickBookButton()
                .fillInPhoneNumber(getTestData("phoneNumber"))
                .completeBooking();
        Assert.assertTrue(bookWithoutCard.isReservationConfirmed(), "Reservation is failed");
    }
}







