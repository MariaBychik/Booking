package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.time.Duration;

public class SearchTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
    }

    @Test  (priority = 2)
    public void dataInputSearch() {
        Search validSearch = new Search(driver);
        validSearch.selectDestination("Maldives");
        validSearch.clickArrive();
        validSearch.selectArriveData("August 2022", "15");
        validSearch.selectDepartureData("August 2022", "30");
        validSearch.selectDetails();
        validSearch.selectAdults("4");
        validSearch.selectChildren("2", "9", "5");
        validSearch.selectCountRoom("2");
        validSearch.runSearch();

        String expUrl = "https://www.booking.com/searchresults.html";
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains(expUrl));

    }


    @Test (priority = 3)
    public void searchFilterUsing() {
        Search filterSearch = new Search(driver);
        filterSearch.mealsSelect("All-inclusive");

        String expTitle = "Hotels in Maldives";
        String actTitle = driver.getTitle();
        Assert.assertTrue(actTitle.contains(expTitle));
    }


    @Test (priority = 1)
    public void searchCarRentals() {
        Search carRentals = new Search(driver);

        carRentals.selectCarTab();
        carRentals.selectLocation("France");
        carRentals.selectDataCarRent();
        carRentals.selectCarRentDataA("August 2022", "15", "12","30");
        carRentals.selectCarRentDataD("16", "11", "45");
        carRentals.searchCar();

        String expUrl = "https://cars.booking.com/SearchResult";
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains(expUrl));
        carRentals.returnHomePage();
    }

    @AfterSuite
    public void TeardownTest() {
        SearchTest.driver.quit();
    }
}











