package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.get("https://www.booking.com");
        driver.manage().getCookies();

    }

    @Test
    public void validRegistrationTest() {
        Registration validSearch = new Registration(driver);
        validSearch.registerPage();
        validSearch.inputEmail("pavelf@mail.ru");
        validSearch.continueRegistration();
        validSearch.selectPassword("12345678qwedQW");
        //validSearch.selectNewPassword("12345678qwedQW");
        //validSearch.selectConfirmedPassword("12345678qwedQW");
        validSearch.continueRegistration();
        //validSearch.holdConfirmButton();



    }
}
