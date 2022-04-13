package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class RegistrationTest {
    public static WebDriver driver;


    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
        driver.manage().getCookies();

    }

    @Test
    //Registration with valid email address
    public void validRegistrationTest() {


        String email = RandomUtils.getEmailString()+"@gmail.com";
        String passwordNew = RandomUtils.getPasswordString();
        String passwordConf = passwordNew;

        Registration validSearch = new Registration(driver);
        validSearch.acceptCookie();
        validSearch.registerPage();
        validSearch.inputEmail(email);
        validSearch.continueRegistration();
        validSearch.selectNewPassword(passwordNew);
        validSearch.selectConfirmedPassword(passwordConf);
        validSearch.confirmRegistration();
        validSearch.confirm();
    }

    @AfterSuite
    public void TeardownTest() {
        RegistrationTest.driver.quit();
    }
}