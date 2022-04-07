package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    public WebDriver driver;

    public Registration(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//span[@class='bui-button__text'])[4]")
    WebElement registerButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement inputTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='new_password']")
    WebElement passwordNewField;

    @FindBy(xpath = "//input[@id='confirmed_password']")
    WebElement passwordConfirmedField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//div[id='eMxPFJBcbVsXszt']")
    WebElement holdButton;

    public void registerPage() {
        registerButton.click();
    }

    public void inputEmail(String email) {
        inputTextBox.sendKeys(email);
    }

    public void continueRegistration() {
        continueButton.click();
    }

    public void selectNewPassword(String passwordNew) {
        passwordNewField.sendKeys(passwordNew);
    }

    public void selectConfirmedPassword(String passwordConf) {
        passwordConfirmedField.sendKeys(passwordConf);
    }

    public void holdConfirmButton() {
        Actions actionProvider = new Actions(driver);
        actionProvider.clickAndHold(holdButton).build().perform();
    }

    public void selectPassword(String passwordInp) {
        {
            passwordField.sendKeys(passwordInp);
        }
    }
}






