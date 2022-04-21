package Booking;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;
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

    public String getTestData(int value) throws IOException {
        ExcelLibrary obj = new ExcelLibrary();
        String dataString = obj.readData("Sheet1", value, 1);
        return dataString;
    }
}


/*
    @AfterSuite
    public void TeardownTest() {
        driver.quit();
    }
}

 */





