package Booking;


import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {

    @Test
    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() {

        Search validSearch = new Search(driver);
        validSearch.acceptCookie()
                .selectDestination(getData("destination"))
                .clickArrive()
                .selectArriveData(getData("expArriveMonth"), getData("expArriveDate"))
                .selectDepartureData(getData("expDepartureMonth"), getData("expDepartureDate"))
                .selectDetails()
                .selectAdultsQuantity(getData("expCountAdult"))
                .selectChildren(getData("expCountChildren"), getData("expCountChildren1"), getData("expCountChildren2"))
                .selectRoomQuantity(getData("expCountRoom"))
                .runSearch()
                .selectMeals(getData("meals"));
        Assert.assertTrue(validSearch.isFoundResultSorted(), "Hotel search failed");
        validSearch.returnHomePage();
    }


    @Test
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() throws Exception {

        Search carRentals = new Search(driver);
        carRentals.selectCarTab()
                .selectLocation(getData("location"))
                .selectDataCarRent()
                .selectCarRentData(getData("expStartCarRentMonth"), getData("expStartCarRentDay"))
                .searchCar();
        Assert.assertTrue(carRentals.isCarExisted(), "Cars not found");
    }

    @Test
    //Search attractions with valid values without authorization in the account
    public void searchAttractions() throws Exception {

        Search attractions = new Search(driver);
        attractions.selectAttractions()
                .selectDestination()
                .selectAttractionFilter(getData("city"))
                .selectAttraction();
        Assert.assertTrue(attractions.isAttractionFound(), "Attraction not found");
        attractions.returnHomePage();
    }
}


















