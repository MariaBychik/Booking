package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReserveTest extends BaseTest {


    @Test
    // Reserve stays with valid values without authorization in the account
    public void booking() throws Exception {

        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie()
                .selectDestination(getData("destinationReserve"))
                .clickArrive()
                .selectArriveData(getData("expArriveMonthReserve"), getData("expArriveDateReserve"))
                .selectDepartureData(getData("expDepartureMonthReserve"), getData("expDepartureDateReserve"))
                .runSearch()
                .selectResults()
                .switchTab()
                .selectRoomQuantity(getData("expCountReserveRoom"))
                .confirmReservation()
                .fillInFirstNameData(getData("firstName"))
                .fillInLastNameData(getData("lastName"))
                .fillInEmail(getData("email"))
                .confirmEmail(getData("email"))
                .selectBookingAim()
                .clickBookButton()
                .fillInPhoneNumber(getData("phoneNumber"))
                .completeBooking();
        Assert.assertTrue(bookWithoutCard.isReservationConfirmed(), "Reservation is failed");
    }
}





