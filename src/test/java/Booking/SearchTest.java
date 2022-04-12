package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() {
        String strDestin ="Maldives";
        String expArriveMonth = "August 2022";
        String expArriveDate = "15";
        String expDepartureMonth= "August 2022";
        String expDepartureDate= "30";
        String expCountAdult= "4";
        String expCountChildren= "2";
        String expCountChildren1= "9";
        String expCountChildren2= "5";
        String expCountRoom= "2";
        String meals ="All-inclusive";

        Search validSearch = new Search(driver);
        validSearch.acceptCookie();
        validSearch.selectDestination(strDestin);
        validSearch.clickArrive();
        validSearch.selectArriveData(expArriveMonth, expArriveDate);
        validSearch.selectDepartureData(expDepartureMonth, expDepartureDate);
        validSearch.selectDetails();
        validSearch.selectAdults(expCountAdult);
        validSearch.selectChildren(expCountChildren, expCountChildren1, expCountChildren2);
        validSearch.selectCountRoom(expCountRoom);
        validSearch.runSearch();
        validSearch.mealsSelect(meals);
        validSearch.confirm();
        validSearch.returnHomePage();
    }

    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() {
        String strLocation = "Milan";
        String expStartCarRentMonth = "August 2022";
        String expStartCarRentDay = "15";

        Search carRentals = new Search(driver);
        carRentals.selectCarTab();
        carRentals.selectLocation(strLocation);
        carRentals.selectDataCarRent();
        carRentals.selectCarRentDataA(expStartCarRentMonth, expStartCarRentDay);
        carRentals.searchCar();
        carRentals.confirmA();
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() {
        String city = "Amsterdam";

        Search attractions = new Search(driver);
        attractions.selectAttractions();
        attractions.selectDestination();
        attractions.selectAttractionFilter(city);
        attractions.selectAttraction();
        attractions.confirmB();
        attractions.returnHomePage();
    }

    @AfterSuite
    public void TeardownTest() {
        SearchTest.driver.quit();
    }
}















