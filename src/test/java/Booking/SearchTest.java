package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() throws Exception {

        Search validSearch = new Search(driver);
        validSearch.acceptCookie()
                .selectDestination(getTestData("destination"))
                .clickArrive()
                .selectArriveData(getTestData("expArriveMonth"), getTestData("expArriveDate"))
                .selectDepartureData(getTestData("expDepartureMonth"), getTestData("expDepartureDate"))
                .selectDetails()
                .selectAdultsQuantity(getTestData("expCountAdult"))
                .selectChildren(getTestData("expCountChildren"), getTestData("expAgeChildren1"),getTestData("expAgeChildren2"))
                .selectRoomQuantity(getTestData("expCountRoom"))
                .runSearch()
                .selectMeals(getTestData("meals"));
        Assert.assertTrue(validSearch.isFoundResultSorted(), "Hotel search failed");
        validSearch.returnHomePage();
    }


    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() throws Exception {

        Search carRentals = new Search(driver);
        carRentals.selectCarTab()
                .selectLocation(getTestData("location"))
                .selectDataCarRent()
                .selectCarRentData(getTestData("expStartCarRentMonth"), getTestData("expStartCarRentDay"))
                .searchCar();
        Assert.assertTrue(carRentals.isCarExisted(), "Cars not found");
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() throws Exception {

        Search attractions = new Search(driver);
        attractions.selectAttractions()
                .selectDestination()
                .selectAttractionFilter(getTestData("city"))
                .selectAttraction();
        Assert.assertTrue(attractions.isAttractionFound(), "Attraction not found");
        attractions.switchTab();
        attractions.returnHomePage();
    }
}




















