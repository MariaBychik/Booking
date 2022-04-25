package Booking;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() throws Exception {

        Search validSearch = new Search(driver);
        validSearch.acceptCookie()
                .selectDestination(getTestData().getDestination())
                .clickArrive()
                .selectArriveData(getTestData().getExpArriveMonth(), getTestData().getExpArriveDate())
                .selectDepartureData(getTestData().getExpDepartureMonth(), getTestData().getExpDepartureDate())
                .selectDetails()
                .selectAdultsQuantity(getTestData().getExpCountAdult())
                .selectChildren(getTestData().getExpCountChildren(), getTestData().getExpAgeChildren())
                .selectRoomQuantity(getTestData().getExpCountRoom())
                .runSearch()
                .selectMeals(getTestData().getMeals());
        Assert.assertTrue(validSearch.isFoundResultSorted(), "Hotel search failed");
        validSearch.returnHomePage();
    }


    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() throws Exception {

        Search carRentals = new Search(driver);
        carRentals.selectCarTab()
                .selectLocation(getTestData().getLocation())
                .selectDataCarRent()
                .selectCarRentData(getTestData().getExpStartCarRentMonth(), getTestData().getExpStartCarRentDay())
                .searchCar();
        Assert.assertTrue(carRentals.isCarExisted(), "Cars not found");
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() throws Exception {

        Search attractions = new Search(driver);
        attractions.selectAttractions()
                .selectDestination()
                .selectAttractionFilter(getTestData().getCity())
                .selectAttraction();
        Assert.assertTrue(attractions.isAttractionFound(), "Attraction not found");
        attractions.switchTab();
        attractions.returnHomePage();
    }
}




















