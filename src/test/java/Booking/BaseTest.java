package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
    }

    @AfterSuite
    public void TeardownTest() {
        driver.quit();
    }
}
