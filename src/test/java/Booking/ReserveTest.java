package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    public void booking() throws InterruptedException {
        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.selectDestination("Batumi");
        bookWithoutCard.clickArrive();
        bookWithoutCard.selectArriveData("June 2022", "5");
        bookWithoutCard.selectDepartureData("June 2022", "10");
        bookWithoutCard.runSearch();
        bookWithoutCard.selectResults();
        bookWithoutCard.switchTab();
        bookWithoutCard.reserveApartment();
        bookWithoutCard.selectRoom("1");
        bookWithoutCard.reserveConfirm();

        String expUrl = "https://secure.booking.com";
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains(expUrl));

    }


    @AfterSuite
    public void TeardownTest() {
        ReserveTest.driver.quit();
    }
}
