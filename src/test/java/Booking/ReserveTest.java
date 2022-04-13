package Booking;


import org.testng.Assert;
import org.testng.annotations.Test;


public class ReserveTest extends BaseTest {

    @Test
    // Reserve stays with valid values without authorization in the account
    public void booking() {
        String destination = "Batumi";
        String expArriveMonth = "May 2022";
        String expArriveDate = "15";
        String expDepartureMonth = "May 2022";
        String expDepartureDate = "20";
        String expCountRoom = "1";
        String firstName = "Pavel";
        String lastName = "Nimale";
        String email = "pavel@gmail.com";
        String phoneNumber = "+8926207543";

        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie();
        bookWithoutCard.selectDestination(destination);
        bookWithoutCard.clickArrive();
        bookWithoutCard.selectArriveData(expArriveMonth, expArriveDate);
        bookWithoutCard.selectDepartureData(expDepartureMonth, expDepartureDate);
        bookWithoutCard.runSearch();
        bookWithoutCard.selectResults();
        bookWithoutCard.switchTab();
        bookWithoutCard.selectRoomQuantity(expCountRoom);
        bookWithoutCard.confirmReservation();
        bookWithoutCard.fillInFirstNameData(firstName);
        bookWithoutCard.fillInLastNameData(lastName);
        bookWithoutCard.fillInEmail(email);
        bookWithoutCard.confirmEmail(email);
        bookWithoutCard.selectBookingAim();
        bookWithoutCard.clickBookButton();
        bookWithoutCard.fillInPhoneNumber(phoneNumber);
        bookWithoutCard.completeBooking();
        Assert.assertTrue(bookWithoutCard.isReservationConfirmed(), "Reservation is failed");
    }
}



