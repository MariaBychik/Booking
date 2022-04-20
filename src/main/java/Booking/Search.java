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

public class Search{

    public WebDriver driver;

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptButton;

    @FindBy(xpath = "//*[@name='ss']")
    WebElement destinationTextBox;

    @FindBy(xpath = "//div[@class='xp__dates-inner']")
    WebElement dataTextBox;

    @FindBy(xpath = "//div[@class = 'bui-calendar__control bui-calendar__control--next']")
    WebElement nextButton;

    @FindBy(xpath = "//*[@class='bui-calendar__month']")
    WebElement monthTextField;

    @FindBy(xpath = "//div[@class = 'xp__input-group xp__guests']")
    WebElement detailsContainer;

    @FindBy(xpath = "//button[@aria-label='Increase number of Adults']")
    WebElement addAdultButton;

    @FindBy(xpath = "(//span[@class='bui-stepper__display'])[1]")
    WebElement adultTextBox;

    @FindBy(xpath = "//button[@aria-label='Increase number of Children']")
    WebElement addChildrenButton;

    @FindBy(xpath = "(//span[@class='bui-stepper__display'])[2]")
    WebElement childrenTextBox;

    @FindBy(xpath = "(//span[@class='bui-stepper__display'])[3]")
    WebElement roomTextBox;

    @FindBy(xpath = "//button[@aria-label='Increase number of Rooms']")
    WebElement addRoomButton;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(), 'Car rentals')]")
    WebElement carTab;

    @FindBy(xpath = "//input[@type='search']")
    WebElement carSearchField;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement carDataField;

    @FindBy(xpath = "(//th[@class='c2-month-header-monthname'][text()='August 2022'])[1]")
    WebElement monthRentCar;

    @FindBy(xpath = "(//span[@class='c2-button-inner'])[2]")
    WebElement nextButton1;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchCarButton;

    @FindBy(xpath = "//*[contains(text(), 'Attractions')]")
    WebElement attractionsButton;

    @FindBy(xpath = "(//div[@class='cad6d4c495'])[8]")
    WebElement destinationTab;

    @FindBy(xpath = "(//span[@class='_082e45fe75'])[7]")
    WebElement viewButton;

    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']")
    WebElement bannerAccept;

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Search acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(bannerAccept));
            acceptButton.click();
        }
        catch(TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Search selectDestination(String destination) {
        destinationTextBox.sendKeys(destination);
        return this;
    }

    public Search clickArrive() {
        dataTextBox.click();
        return this;
    }

    public Search selectArriveData(String expArriveMonth, String expArriveDate) {
        while (true) {
            String monthArrive = monthTextField.getText();
            if (monthArrive.equals(expArriveMonth)) {
                break;
            } else {
                nextButton.click();
            }
        }

        List<WebElement> cell = driver.findElements(By.xpath("(//tbody[1]//tr//td/span)"));
        for (WebElement arrivalDate : cell) {
            String dateArrive = arrivalDate.getText();
            if (dateArrive.equals(expArriveDate)) {
                arrivalDate.click();
                break;
            }
        }
        return this;
    }

    public Search selectDepartureData(String expDepartureMonth, String expDepartureDate) {
        while (true) {
            String monthDeparture = monthTextField.getText();
            if (monthDeparture.equals(expDepartureMonth)) {
                break;
            } else {
                nextButton.click();
            }
        }

        List<WebElement> cell = driver.findElements(By.xpath("(//tbody[1]//tr//td/span)"));
        for (WebElement departureDate : cell) {
            String date = departureDate.getText();
            if (date.equals(expDepartureDate)) {
                departureDate.click();
                break;
            }
        }
        return this;
    }

    public Search selectDetails() {
        detailsContainer.click();
        return this;
    }

    public Search selectAdultsQuantity(String expCountAdult) {
        while (true) {
            String countAdult = adultTextBox.getText();
            if (countAdult.equals(expCountAdult)) {
                break;
            } else {
                addAdultButton.click();
            }
        }
        return this;
    }

    public Search selectChildren(String expCountChildren, String expAgeChildren1, String expAgeChildren2) {
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
        return this;
    }

    public Search selectRoomQuantity(String expCountRoom) {
        while (true) {
            String countRoom = roomTextBox.getText();
            if (countRoom.equals(expCountRoom)) {
                break;
            } else {
                addRoomButton.click();
            }
        }
        return this;
    }

    public Search runSearch() {
        searchButton.click();
        return this;
    }


    public Search selectMeals(String meals) {
     String xpath = "//div[@data-filters-group='mealplan']/descendant::*[contains(text(), '%s')]";
        if (!driver.findElement(By.xpath(String.format(xpath, meals))).isSelected()) {
            driver.findElement(By.xpath(String.format(xpath, meals))).click();
        }
        return this;
    }

    public boolean isFoundResultSorted(){
        WebElement propertiesMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.xpath("//div[@class='efdb2b543b']")));
        return propertiesMessage.getText().contains("properties found");
    }

    public Search returnHomePage() {
        driver.navigate().to("https://www.booking.com");
        return this;
    }

    public Search selectCarTab()  {
            carTab.click();
            return this;
        }

    public Search selectLocation(String strLocation) {
        carSearchField.sendKeys(strLocation);
        driver.findElement(By.xpath("//li[@data-i='4']")).click();
        return this;
    }

    public Search selectDataCarRent() {
        carDataField.click();
        return this;
    }

    public Search selectCarRentData(String expStartCarRentMonth, String expStartCarRentDay) {
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
        return this;
    }

        public Search searchCar() {
            searchCarButton.click();
            return this;
        }

        public boolean isCarExisted(){
        boolean carIsAvailable = false;
        try{
            carIsAvailable = isCarAvailable();
        }
        catch(TimeoutException e){
            carIsAvailable = isCarFound();
        }
        return carIsAvailable;
    }

        public Search selectAttractions(){
           attractionsButton.click();
           return this;
        }

        public Search selectDestination(){
          destinationTab.click();
          return this;
        }

        public Search selectAttractionFilter(String city) {
        String xpath = "//div[@class='_85d06581c8']/descendant::*[contains(text(), '%s')]";
        if (!driver.findElement(By.xpath(String.format(xpath, city))).isSelected()) {
            driver.findElement(By.xpath(String.format(xpath, city))).click();
        }
        return this;
    }

    public Search selectAttraction(){
        viewButton.click();
        return this;
    }

    public Search switchTab() {
        String tab = driver.getWindowHandle();
        driver.switchTo().window(tab);
        return this;
    }

    public boolean isAttractionFound(){
            WebElement foundedMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(driver -> driver.findElement(By.xpath("//nav[@class='_806745cd2f']")));
            return foundedMessage.getText().contains("Attractions");
    }

    private boolean isCarAvailable() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.xpath("//div[@data-testid='page-title']"))).getText().contains("available");
    }

    private boolean isCarFound(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.xpath("//form[@name='SearchResultsForm']"))).getText().contains("find");
    }

    }






















