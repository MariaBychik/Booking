package Booking;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;


@Listeners({TestListener.class})
public class SearchTest extends BaseTest {


    @Test (priority = 0, description="Search hotels with valid values")
    @Description("Test Description: Search test without authorization in the account")

    //Search hotels with valid values without authorization in the account
    public void dataInputSearch() throws Exception {

        Search validSearch = new Search(driver);
        validSearch.returnHomePage();
        validSearch.returnHomePage();
        validSearch.acceptCookie()
                .selectDestination(getTestData("destination"))
                .clickArrive()
                .selectArriveData(getTestData("expArriveMonth"), getTestData("expArriveDate"))
                .selectDepartureData(getTestData("expDepartureMonth"), getTestData("expDepartureDate"))
                .selectDetails()
                .selectAdultsQuantity(getTestData("expCountAdult"))
                .selectChildren(getTestData("expCountChildren"), getTestData("expAgeChildren1"), getTestData("expAgeChildren2"))
                .selectRoomQuantity(getTestData("expCountRoom"))
                .runSearch()
                .selectMeals(getTestData("meals"));
        Assert.assertTrue(validSearch.isFoundResultSorted(), "Hotel search failed");
        validSearch.returnHomePage();
    }

    @Test(priority = 2,description="Search car rentals with valid values")
    @Description("Test Description: Search test without authorization in the account")
    //Search cars with valid values without authorization in the account
    public void searchCarRentals() throws Exception {

        Search carRentals = new Search(driver);
        carRentals.selectCarTab()
                .selectLocation(getTestData("location"))
                .selectDataCarRent()
                .selectCarRentData(getTestData("expStartCarRentMonth"), getTestData("expStartCarRentDay"))
                .searchCar();
        Assert.assertTrue(carRentals.isCarExisted(), "Cars not found");
        carRentals.returnHomePage();
    }


    @Test (priority = 1,description="Search attractions with valid values")
    @Description("Test Description: Search test without authorization in the account")
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




















