package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;


public class ReserveTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
    }

    @Test
    // Reserve stays with valid values without authorization in the account
    public void booking() {
        String strDesin = "Batumi";
        String expArriveMonth = "May 2022";
        String expArriveDate = "15";
        String expDepartureMonth= "May 2022";
        String expDepartureDate= "20";
        String expCountRoom= "1";
        String fName= "Pavel";
        String lName= "Nimale";
        String emailF = "pavel@gmail.com";
        String emailC = "pavel@gmail.com";
        String phoneNumber = "+8926207543";

        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie();
        bookWithoutCard.selectDestination(strDesin);
        bookWithoutCard.clickArrive();
        bookWithoutCard.selectArriveData(expArriveMonth, expArriveDate);
        bookWithoutCard.selectDepartureData(expDepartureMonth, expDepartureDate);
        bookWithoutCard.runSearch();
        bookWithoutCard.selectResults();
        bookWithoutCard.switchTab();
        bookWithoutCard.selectRoom(expCountRoom);
        bookWithoutCard.reserveConfirm();
        bookWithoutCard.fillInFirstNameData(fName);
        bookWithoutCard.fillInLastNameData(lName);
        bookWithoutCard.fillInEmail(emailF);
        bookWithoutCard.confirmEmail(emailC);
        bookWithoutCard.selectBookingAim();
        bookWithoutCard.bookSubmit();
        bookWithoutCard.fillInPhone(phoneNumber);
        bookWithoutCard.completeBooking();
        bookWithoutCard.confirm();
    }

   @AfterSuite
    public void TeardownTest() {
        ReserveTest.driver.quit();
    }
}

