package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

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
    //Registration with valid email address
    public void validRegistrationTest() {
        Registration validSearch = new Registration(driver);
        validSearch.acceptCookie();
        validSearch.registerPage();
        validSearch.inputEmail("ravelofoed@mail.ru");
        validSearch.continueRegistration();
        validSearch.selectNewPassword("uytRFD6543Egr");
        validSearch.selectConfirmedPassword("uytRFD6543Egr");
        validSearch.continueRegistration();

        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//span[@id='profile-menu-trigger--title']")));
        assertEquals(confirm.getText().contains("Your account"), true);

    }
}

