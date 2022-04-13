package Booking;

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

    @FindBy(xpath = "(//div[@data-testid='title'])[1]")
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
    
    public void acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(bannerAccept));
            acceptButton.click();
        }
        catch(TimeoutException e) {
            e.printStackTrace();
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

        List<WebElement> cell = driver.findElements(By.xpath("//tbody[1]//tr//td/span"));
        for (WebElement arriveDate : cell) {
            String dateArrive = arriveDate.getText();
            if (dateArrive.equals(expArriveDate)) {
                arriveDate.click();
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

        List<WebElement> cell = driver.findElements(By.xpath("//tbody[1]//tr//td/span"));
        for (WebElement departureDate : cell) {
            String date = departureDate.getText();
            if (date.equals(expDepartureDate)) {
                departureDate.click();
                break;
            }
        }
    }

    public void runSearch() {searchButton.click();}

    public void selectResults() {searchResults.click();}

    public void switchTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public void selectRoomQuantity(String expCountRoom){
        dropDownRoomButton.click();
        String selectCountRoom = "(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]/descendant::*[contains(text(),'%s')][1]";
        if (!driver.findElement(By.xpath(String.format(selectCountRoom, expCountRoom))).isSelected())
            driver.findElement(By.xpath(String.format(selectCountRoom, expCountRoom))).click();
    }

    public void confirmReservation(){
        reserveConfirmButton.click();
    }

    public void fillInFirstNameData(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void fillInLastNameData(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void fillInEmail(String email){
        emailField.sendKeys(email);
    }

    public void confirmEmail(String email){
        emailConfField.sendKeys(email);
    }

    public void selectBookingAim(){
        radioButton.click();
    }

    public void clickBookButton(){
        bookButton.click();
    }

    public void fillInPhoneNumber(String phoneNumber){
        phoneTextBox.sendKeys(phoneNumber);
    }

    public void completeBooking(){
        completeButton.click();
    }

    public boolean isReservationConfirmed(){
        WebElement reservationMessage = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//span[@class='conf-page-gem-offers__badge-text']")));
         return reservationMessage.getText().contains("is confirmed");
    }
}
