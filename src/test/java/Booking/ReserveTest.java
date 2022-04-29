package Booking;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

@Listeners({TestListener.class})
public class ReserveTest extends BaseTest {

    @Test(priority = 3,description="Reserve stays with valid values")
    @Description("Test Description: Reserve test without authorization in the account")
    // Reserve stays with valid values without authorization in the account
    public void booking() throws Exception {
        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.returnHomePage();
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
        bookWithoutCard.returnHomePage();
    }
}









