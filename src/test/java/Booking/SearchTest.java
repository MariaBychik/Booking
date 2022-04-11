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

public class SearchTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.booking.com");
    }

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() {
        Search validSearch = new Search(driver);
        validSearch.acceptCookie();
        validSearch.selectDestination("Maldives");
        validSearch.clickArrive();
        validSearch.selectArriveData("August 2022", "15");
        validSearch.selectDepartureData("August 2022", "30");
        validSearch.selectDetails();
        validSearch.selectAdults("4");
        validSearch.selectChildren("2", "9", "5");
        validSearch.selectCountRoom("2");
        validSearch.runSearch();
        validSearch.mealsSelect("All-inclusive");

        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//div[@class='efdb2b543b']")));
        assertEquals(confirm.getText().contains("properties found"), true);

        validSearch.returnHomePage();
    }

    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() {
        Search carRentals = new Search(driver);
        carRentals.selectCarTab();
        carRentals.selectLocation("Milan");
        carRentals.selectDataCarRent();
        carRentals.selectCarRentDataA("August 2022", "15", "10", "15");
        carRentals.searchCar();

        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//div[@data-testid='page-title']")));
        assertEquals(confirm.getText().contains("cars available"), true);
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() {
        Search attractions = new Search(driver);
        attractions.selectAttractions();
        attractions.selectDestination();
        attractions.selectAttractionFilter("Amsterdam");
        attractions.selectAttraction();

        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//nav[@class='_806745cd2f']")));
        assertEquals(confirm.getText().contains("Attractions"), true);

        attractions.returnHomePage();
    }

    @AfterSuite
    public void TeardownTest() {
        SearchTest.driver.quit();
    }
}













