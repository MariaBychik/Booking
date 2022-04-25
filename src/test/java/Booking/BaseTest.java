package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

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

    public String getTestData(String value) throws IOException {
        Map<String, String> testData = ReadExcel.readExcelFile();
        for (Map.Entry<String, String> map : testData.entrySet()) {
            if (map.getKey().equals(value)) {
                return map.getValue();
            }
        }
        return null;
    }


    @AfterSuite
    public void TeardownTest() {
        driver.quit();
    }
}








