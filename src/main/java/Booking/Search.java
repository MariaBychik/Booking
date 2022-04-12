package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class Search {

    public WebDriver driver;

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptButton;

    @FindBy(xpath = "//*[@name='ss']")
    WebElement destinationTextBox;

    @FindBy(xpath = "//*[@role = 'presentation'][@class ='bk-icon -experiments-calendar sb-date-picker_icon-svg']")
    WebElement dataTextBox;

    @FindBy(xpath = "//div[@class = 'bui-calendar__control bui-calendar__control--next']")
    WebElement nextButton;

    @FindBy(xpath = "//*[@class='bui-calendar__month']")
    WebElement monthTextField;

    @FindBy(xpath = "//div[@class = 'xp__input-group xp__guests']")
    WebElement detailsContainer;

    @FindBy(xpath = "(//button[@class='bui-button bui-button--secondary bui-stepper__add-button '])[1]")
    WebElement addAdultButton;

    @FindBy(xpath = "(//span[@class='bui-stepper__display'])[1]")
    WebElement adultTextBox;

    @FindBy(xpath = "(//button[@class='bui-button bui-button--secondary bui-stepper__add-button '])[2]")
    WebElement addChildrenButton;

    @FindBy(xpath = "(//span[@class='bui-stepper__display'])[2]")
    WebElement childrenTextBox;

    @FindBy(xpath = "(//span[@class='bui-stepper__display'])[3]")
    WebElement roomTextBox;

    @FindBy(xpath = "(//span[@class='bui-button__text'])[11]")
    WebElement addRoomButton;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchButton;

    @FindBy(xpath = "(//span[@class='bui-tab__text'])[4]")
    WebElement carTab;

    @FindBy(xpath = "//input[@type='search']")
    WebElement carSearchField;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement carDataField;

    @FindBy(xpath = "(//th[@class='c2-month-header-monthname'][text()='August 2022'])[1]")
    WebElement monthRentCar;

    @FindBy(xpath = "(//span[@class='c2-button-inner'])[2]")
    WebElement nextButton1;

    @FindBy(xpath = "//select[@name='checkinTime']")
    WebElement checkInTimeHour;

    @FindBy(xpath = "//select[@name='checkinTimeMinutes']")
    WebElement checkInTimeMinutes;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchCarButton;

    @FindBy(xpath = "(//span[@class='bui-tab__text'])[5]")
    WebElement attractionsButton;

    @FindBy(xpath = "(//div[@class='cad6d4c495'])[8]")
    WebElement destinationTab;

    @FindBy(xpath = "(//span[@class='_082e45fe75'])[7]")
    WebElement viewButton;

    public void acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='onetrust-banner-sdk']")));
            acceptButton.click();
        }
        catch(TimeoutException e) {

        }
    }

    public void selectDestination(String strDestin) {
        destinationTextBox.sendKeys(strDestin);
    }

    public void clickArrive() {
        dataTextBox.click();
    }

    public void selectArriveData(String expArriveMonth, String expArriveDate) {
        while (true) {
            String monthArrive = monthTextField.getText();
            if (monthArrive.equals(expArriveMonth)) {
                break;
            } else {
                nextButton.click();
            }
        }
        List<WebElement> cell = driver.findElements(By.xpath("(//tbody[1]//tr//td/span)"));
        for (WebElement element1 : cell) {
            String dateArrive = element1.getText();
            if (dateArrive.equals(expArriveDate)) {
                element1.click();
                break;
            }
        }
    }

    public void selectDepartureData(String expDepartureMonth, String expDepartureDate) {
        while (true) {
            String monthDeparture = monthTextField.getText();
            if (monthDeparture.equals(expDepartureMonth)) {
                break;
            } else {
                nextButton.click();
            }
        }
        List<WebElement> cell = driver.findElements(By.xpath("(//tbody[1]//tr//td/span)"));
        for (WebElement element1 : cell) {
            String date = element1.getText();
            if (date.equals(expDepartureDate)) {
                element1.click();
                break;
            }
        }
    }

    public void selectDetails() {
        detailsContainer.click();
    }

    public void selectAdults(String expCountAdult) {
        while (true) {
            String countAdult = adultTextBox.getText();
            if (countAdult.equals(expCountAdult)) {
                break;
            } else {
                addAdultButton.click();
            }
        }
    }

    public void selectChildren(String expCountChildren, String expAgeChildren1, String expAgeChildren2) {
        while (true) {
            String countChildren = childrenTextBox.getText();
            if (countChildren.equals(expCountChildren)) {
                break;
            } else {
                addChildrenButton.click();
                Select ageChildren1 = new Select(driver.findElement(By.xpath("//select[@name='age']")));
                ageChildren1.selectByValue(expAgeChildren1);
                addChildrenButton.click();
                Select ageChildren2 = new Select(driver.findElement(By.xpath("//select[@name='age'][2]")));
                ageChildren2.selectByValue(expAgeChildren2);

            }
        }
    }

    public void selectCountRoom(String expCountRoom) {
        while (true) {
            String countRoom = roomTextBox.getText();
            if (countRoom.equals(expCountRoom)) {
                break;
            } else {
                addRoomButton.click();
            }
        }
    }

    public void runSearch() {
        searchButton.click();
    }


    public void mealsSelect(String meals) {
     String xpath = "//div[@data-filters-group='mealplan']/descendant::*[contains(text(), '%s')]";
        if (!driver.findElement(By.xpath(String.format(xpath, meals))).isSelected()) {
            driver.findElement(By.xpath(String.format(xpath, meals))).click();
        }
    }

    public void confirm(){
        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.xpath("//div[@class='efdb2b543b']")));
        assertEquals(confirm.getText().contains("properties found"), true);
    }

    public void returnHomePage() {
        driver.navigate().to("https://www.booking.com");}


    public void selectCarTab()  {
        carTab.click();
    }

    public void selectLocation(String strLocation) {
        carSearchField.sendKeys(strLocation);
        driver.findElement(By.xpath("//li[@data-i='4']")).click();
    }

    public void selectDataCarRent() {
        carDataField.click();
    }

    public void selectCarRentDataA(String expStartCarRentMonth, String expStartCarRentDay) {
        while (true) {
            String startCarRentMonth = monthRentCar.getText();
            if (startCarRentMonth.equals(expStartCarRentMonth)) {
                break;
            } else {
                nextButton1.click();
            }
        }

        List<WebElement> cell = driver.findElements(By.xpath("//tbody[1]//tr//td//span"));
        for (WebElement elem : cell) {
            String dateStartRentCar = elem.getText();
            if (dateStartRentCar.equals(expStartCarRentDay)) {
                elem.click();
                break;
            }
        }
    }



        public void searchCar() {
            searchCarButton.click();
        }

        public void confirmA(){
            WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                    .until(driver -> driver.findElement(By.xpath("//div[@data-testid='page-title']")));
            assertEquals(confirm.getText().contains("cars available"), true);
        }

        public void selectAttractions(){
            attractionsButton.click();
        }

        public void selectDestination(){
          destinationTab.click();
        }

        public void selectAttractionFilter(String city) {
        String xpath = "//div[@class='_85d06581c8']/descendant::*[contains(text(), '%s')]";
        if (!driver.findElement(By.xpath(String.format(xpath, city))).isSelected()) {
            driver.findElement(By.xpath(String.format(xpath, city))).click();
        }
    }

    public void selectAttraction(){
        viewButton.click();
    }

    public void confirmB(){
        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//nav[@class='_806745cd2f']")));
        assertEquals(confirm.getText().contains("Attractions"), true);
    }


}



















