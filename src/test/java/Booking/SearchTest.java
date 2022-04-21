package Booking;


import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() throws Exception {

        Search validSearch = new Search(driver);
        validSearch.acceptCookie()
                .selectDestination(getTestData(0))
                .clickArrive()
                .selectArriveData(getTestData(1), getTestData(2))
                .selectDepartureData(getTestData(3), getTestData(4))
                .selectDetails()
                .selectAdultsQuantity(getTestData(5))
                .selectChildren(getTestData(6), getTestData(7), getTestData(8))
                .selectRoomQuantity(getTestData(9))
                .runSearch()
                .selectMeals(getTestData(10));
        Assert.assertTrue(validSearch.isFoundResultSorted(), "Hotel search failed");
        validSearch.returnHomePage();
    }


    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() throws Exception {

        Search carRentals = new Search(driver);
        carRentals.selectCarTab()
                .selectLocation(getTestData(11))
                .selectDataCarRent()
                .selectCarRentData(getTestData(12), getTestData(13))
                .searchCar();
        Assert.assertTrue(carRentals.isCarExisted(), "Cars not found");
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() throws Exception {

        Search attractions = new Search(driver);
        attractions.selectAttractions()
                .selectDestination()
                .selectAttractionFilter(getTestData(14))
                .selectAttraction();
        Assert.assertTrue(attractions.isAttractionFound(), "Attraction not found");
        attractions.switchTab();
        attractions.returnHomePage();
    }
}




















