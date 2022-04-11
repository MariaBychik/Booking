package Booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Reserve{
    public WebDriver driver;

    public Reserve(WebDriver driver) {
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

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@data-testid='title'])[1]")
    WebElement searchResults;

    @FindBy(xpath = "(//span[@class='bui-button__text'])[20]")
    WebElement reserveButton;

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


    public void acceptCookie(){acceptButton.click();}

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

    public void runSearch() {searchButton.click();}

    public void selectResults() {searchResults.click();}

    public void switchTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }
    public void reserveApartment(){
        reserveButton.click();}

    public void selectRoom(String expCountRoom){
        dropDownRoomButton.click();
        String selectCountRoom = "(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]/descendant::*[contains(text(),'%s')][1]";
        if (!driver.findElement(By.xpath(String.format(selectCountRoom, expCountRoom))).isSelected())
            driver.findElement(By.xpath(String.format(selectCountRoom, expCountRoom))).click();
    }

    public void reserveConfirm(){
        reserveConfirmButton.click();
    }

    public void fillInFirstNameData(String fName){
        firstNameField.sendKeys(fName);
    }

    public void fillInLastNameData(String lName){
        lastNameField.sendKeys(lName);
    }

    public void fillInEmail(String emailF){
        emailField.sendKeys(emailF);
    }

    public void confirmEmail(String emailC){
        emailConfField.sendKeys(emailC);
    }

    public void selectBookingAim(){
        radioButton.click();
    }

    public void bookSubmit(){
        bookButton.click();
    }

    public void fillInPhone(String phoneNumber){
        phoneTextBox.sendKeys(phoneNumber);
    }

    public void completeBooking(){
        completeButton.click();

    }
}
