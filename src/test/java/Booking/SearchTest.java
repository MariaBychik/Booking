package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() {
        String destination = "Maldives";
        String expArriveMonth = "August 2022";
        String expArriveDate = "15";
        String expDepartureMonth = "August 2022";
        String expDepartureDate = "30";
        String expCountAdult = "4";
        String expCountChildren = "2";
        String expCountChildren1 = "9";
        String expCountChildren2 = "5";
        String expCountRoom = "2";
        String meals = "All-inclusive";

        Search validSearch = new Search(driver);
        validSearch.acceptCookie()
                .selectDestination(destination)
                .clickArrive()
                .selectArriveData(expArriveMonth, expArriveDate)
                .selectDepartureData(expDepartureMonth, expDepartureDate)
                .selectDetails()
                .selectAdultsQuantity(expCountAdult)
                .selectChildren(expCountChildren, expCountChildren1, expCountChildren2)
                .selectRoomQuantity(expCountRoom)
                .runSearch()
                .selectMeals(meals);
        Assert.assertTrue(validSearch.isFoundResultSorted(), "Hotel search failed");
        validSearch.returnHomePage();
    }

    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() {
        String location = "Milan";
        String expStartCarRentMonth = "August 2022";
        String expStartCarRentDay = "15";

        Search carRentals = new Search(driver);
        carRentals.selectCarTab()
                .selectLocation(location)
                .selectDataCarRent()
                .selectCarRentData(expStartCarRentMonth, expStartCarRentDay)
                .searchCar();
        Assert.assertTrue(carRentals.isCarExisted(), "Cars not found");
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() {
        String city = "Amsterdam";

        Search attractions = new Search(driver);
        attractions.selectAttractions()
                .selectDestination()
                .selectAttractionFilter(city)
                .selectAttraction();
        Assert.assertTrue(attractions.isAttractionFound(), "Attraction not found");
        attractions.returnHomePage();
    }
}

















