package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class RegistrationTest extends BaseTest {


    @Test
    //Registration with valid email address
    public void validRegistrationTest() {

        String email = RandomUtils.getEmailString() + "@gmail.com";
        String passwordNew = RandomUtils.getPasswordString();
        String passwordConf = passwordNew;

        Registration validSearch = new Registration(driver);
        validSearch.acceptCookie()
                .registerPage()
                .inputEmail(email)
                .continueRegistration()
                .enterNewPassword(passwordNew)
                .enterConfirmedPassword(passwordConf)
                .confirmRegistration();
        Assert.assertTrue(validSearch.isUserLoggedIn(), "User is not logged in");
    }
}