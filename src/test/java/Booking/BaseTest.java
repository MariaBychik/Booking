package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.time.Duration;


public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.booking.com");
    }

    public static TestData getTestData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TestData myTestData = mapper.readValue(new File("src/test/resources/dataJson.json" ), TestData.class);
        return myTestData;
    }


    @AfterSuite
    public void TeardownTest() {
        driver.quit();
    }
}








