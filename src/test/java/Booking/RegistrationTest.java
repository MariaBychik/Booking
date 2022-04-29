package Booking;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

@Listeners({TestListener.class})
public class RegistrationTest extends BaseTest {

    @Test(priority = 4,description="Registration with valid email address")
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
        validSearch.returnHomePage();
    }
}




