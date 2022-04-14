package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    //Registration with valid email address
    public void validRegistrationTest() {

        String email = RandomUtils.getEmailString() + "@gmail.com";
        String passwordNew = RandomUtils.getPasswordString();
        String passwordConfirmed = passwordNew;

        Registration validSearch = new Registration(driver);
        validSearch.acceptCookie()
                .switchToRegisterPage()
                .inputEmail(email)
                .continueRegistration()
                .enterNewPassword(passwordNew)
                .enterConfirmedPassword(passwordConfirmed)
                .confirmRegistration();
        Assert.assertTrue(validSearch.isUserLoggedIn(), "User is not logged in");
    }
}

