package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Search {

    public WebDriver driver;

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

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

    @FindBy(xpath = "(//li[@class='bui-tab__item'])[3]")
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

    @FindBy(xpath = "//select[@name='checkoutTime']")
    WebElement checkOutTimeHour;

    @FindBy(xpath = "//select[@name='checkoutTimeMinutes']")
    WebElement checkOutTimeMinutes;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchCarButton;

    @FindBy(xpath = "//span[@class='bbdb949247']")
    WebElement checkBox;


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

    public void returnHomePage() {driver.navigate().to("https://www.booking.com");;}


    public void selectCarTab() {
        carTab.click();
    }

    public void selectLocation(String strLocation) {
        carSearchField.sendKeys(strLocation);
        driver.findElement(By.xpath("//li[@data-i='4']")).click();
    }

    public void selectDataCarRent() {
        carDataField.click();
    }

    public void selectCarRentDataA(String expStartCarRentMonth, String expStartCarRentDay, String expArriveHour, String expArriveMinute) {
        while (true) {
            String startCarRentMonth = monthRentCar.getText();
            if (startCarRentMonth.equals(expStartCarRentMonth)) {
                break;
            } else {
                nextButton1.click();
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

        checkInTimeHour.click();
        String selectArriveTime = "(//option[@value='%s'])[1]";
        if (!driver.findElement(By.xpath(String.format(selectArriveTime, expArriveHour))).isSelected())
            driver.findElement(By.xpath(String.format(selectArriveTime, expArriveHour))).click();

        checkInTimeMinutes.click();
        String selectArriveMinute = "(//option[@value='%s'])[1]";
        if (!driver.findElement(By.xpath(String.format(selectArriveMinute, expArriveMinute))).isSelected())
            driver.findElement(By.xpath(String.format(selectArriveMinute, expArriveMinute))).click();

    }


    public void selectCarRentDataD(String expEndCarRentDay, String expDepartureHour, String expDepartureMinute) {
        List<WebElement> cell = driver.findElements(By.xpath("//tbody[1]//tr//td//span"));
        for (WebElement elem : cell) {
            String dateStartRentCar = elem.getText();
            if (dateStartRentCar.equals(expEndCarRentDay)) {
                elem.click();
                break;
            }
        }

        carDataField.click();
        checkOutTimeHour.click();
        String selectDepartureTime = "(//option[@value='%s'])[2]";
        if (!driver.findElement(By.xpath(String.format(selectDepartureTime, expDepartureHour))).isSelected())
            driver.findElement(By.xpath(String.format(selectDepartureTime, expDepartureHour))).click();

        checkOutTimeMinutes.click();
        String selectDepartureMinute = "(//option[@value='%s'])[2]";
        if (!driver.findElement(By.xpath(String.format(selectDepartureMinute, expDepartureMinute))).isSelected())
            driver.findElement(By.xpath(String.format(selectDepartureMinute, expDepartureMinute))).click();
    }

        public void searchCar() {
            searchCarButton.click();
        }


}



















