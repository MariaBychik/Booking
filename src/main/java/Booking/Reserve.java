package Booking;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Reserve{
    public WebDriver driver;

    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']")
    WebElement bannerAccept;

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

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@class='d506630cf3'][text()='No prepayment needed'])[1]")
    WebElement searchResults;

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    WebElement reserveConfirmButton;

    @FindBy(xpath = "(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]")
    WebElement dropDownRoomButton;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameField;

    @FindBy(xpath="//input[@id='lastname']")
    WebElement lastNameField;

    @FindBy(xpath="//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath="//input[@id='email_confirm']")
    WebElement emailConfField;

    @FindBy(xpath = "(//span[@class='bui-radio__label'])[3]")
    WebElement radioButton;

    @FindBy(xpath = "//button[@name='book']")
    WebElement bookButton;

    @FindBy (xpath = "//input[@id='phone']")
    WebElement phoneTextBox;

    @FindBy (xpath = "(//span[@class='bui-button__text js-button__text'])[2]")
    WebElement completeButton;

    public Reserve(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Accepting cookies if they exist on the page")
    public Reserve acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(bannerAccept));
            acceptButton.click();
        }
        catch(TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Selection a destination: {0}")
    public Reserve selectDestination(String destination) {
        destinationTextBox.sendKeys(destination);
        return this;
    }

    public Reserve clickArrive() {
        dataTextBox.click();
        return this;
    }

    @Step("Selection the month of arrival: {0} and the day of arrival: {1}")
    public Reserve selectArriveData(String expArriveMonth, String expArriveDate) {
        while (true) {
            String monthArrive = monthTextField.getText();
            if (monthArrive.equals(expArriveMonth)) {
                break;
            } else {
                nextButton.click();
            }
        }

        List<WebElement> cell = driver.findElements(By.xpath("//tbody[1]//tr//td/span"));
        for (WebElement arriveDate : cell) {
            String dateArrive = arriveDate.getText();
            if (dateArrive.equals(expArriveDate)) {
                arriveDate.click();
                break;
            }
        }
        return this;
    }

    @Step("Selection the month of departure: {0} and the day of departure: {1}")
    public Reserve selectDepartureData(String expDepartureMonth, String expDepartureDate) {
        while (true) {
            String monthDeparture = monthTextField.getText();
            if (monthDeparture.equals(expDepartureMonth)) {
                break;
            } else {
                nextButton.click();
            }
        }

        List<WebElement> cell = driver.findElements(By.xpath("//tbody[1]//tr//td/span"));
        for (WebElement departureDate : cell) {
            String date = departureDate.getText();
            if (date.equals(expDepartureDate)) {
                departureDate.click();
                break;
            }
        }
        return this;
    }

    @Step("Click Search button")
    public Reserve runSearch() {
        searchButton.click();
        return this;
    }

    @Step("Select a hotel based on search results")
    public Reserve selectResults() {
        searchResults.click();
        return this;
    }

    public Reserve switchTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    @Step("Selection quantity of room: {0}")
    public Reserve selectRoomQuantity(String expCountRoom){
        dropDownRoomButton.click();
        String selectCountRoom = "(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]/descendant::*[contains(text(),'%s')][1]";
        if (!driver.findElement(By.xpath(String.format(selectCountRoom, expCountRoom))).isSelected())
            driver.findElement(By.xpath(String.format(selectCountRoom, expCountRoom))).click();
        return this;
    }

    @Step("Click Confirm button")
    public Reserve confirmReservation(){
        reserveConfirmButton.click();
        return this;
    }

    @Step("Fill in first name: {0}")
    public Reserve fillInFirstNameData(String firstName){
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Fill in last name: {0}")
    public Reserve fillInLastNameData(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Fill in email: {0}")
    public Reserve fillInEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    @Step("Confirm email: {0}")
    public Reserve confirmEmail(String email){
        emailConfField.sendKeys(email);
        return this;
    }

    @Step("Select booking aim")
    public Reserve selectBookingAim(){
        radioButton.click();
        return this;
    }

    @Step("Click Book button")
    public Reserve clickBookButton(){
        bookButton.click();
        return this;
    }

    @Step("Fill in phone number: {0}")
    public Reserve fillInPhoneNumber(String phoneNumber){
        phoneTextBox.sendKeys(phoneNumber);
        return this;
    }

    @Step("Click Complete button")
    public Reserve completeBooking(){
        completeButton.click();
        return this;
    }

    @Step("Verify that reservation is confirmed")
    public boolean isReservationConfirmed(){
        WebElement reservationMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.xpath("//span[@class='conf-page-gem-offers__badge-text']")));
       return reservationMessage.getText().contains("is confirmed");
    }

    public Reserve returnHomePage() {
        driver.navigate().to("https://www.booking.com");
        return this;
    }
}
