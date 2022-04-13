package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

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
        validSearch.selectAdultsQuantity(expCountAdult);
        validSearch.selectChildren(expCountChildren, expCountChildren1, expCountChildren2);
        validSearch.selectRoomQuantity(expCountRoom);
        validSearch.runSearch();
        validSearch.selectMeals(meals);
        Assert.assertTrue(validSearch.isFoundResultSorted(), "");
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
        carRentals.selectCarRentData(expStartCarRentMonth, expStartCarRentDay);
        carRentals.searchCar();
        carRentals.isCarAvailable();
        carRentals.isCarFound();
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
}















