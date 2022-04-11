package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

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
        Reserve bookWithoutCard = new Reserve(driver);
        bookWithoutCard.acceptCookie();
        bookWithoutCard.selectDestination("Batumi");
        bookWithoutCard.clickArrive();
        bookWithoutCard.selectArriveData("May 2022", "5");
        bookWithoutCard.selectDepartureData("May 2022", "10");
        bookWithoutCard.runSearch();
        bookWithoutCard.selectResults();
        bookWithoutCard.switchTab();
        bookWithoutCard.reserveApartment();
        bookWithoutCard.selectRoom("1");
        bookWithoutCard.reserveConfirm();
        bookWithoutCard.fillInFirstNameData("Pavel");
        bookWithoutCard.fillInLastNameData("Nimale");
        bookWithoutCard.fillInEmail("pavel@gmail.com");
        bookWithoutCard.confirmEmail("pavel@gmail.com");
        bookWithoutCard.selectBookingAim();
        bookWithoutCard.bookSubmit();
        bookWithoutCard.fillInPhone("+8926207543");
        bookWithoutCard.completeBooking();

        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//span[@class='conf-page-gem-offers__badge-text']")));
        assertEquals(confirm.getText(), "Your booking in Batumi is confirmed");

    }


    @AfterSuite
    public void TeardownTest() {
        ReserveTest.driver.quit();
    }
}
