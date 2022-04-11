package Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    public WebDriver driver;

    public Registration(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptButton;

    @FindBy(xpath = "(//a[@class='bui-button bui-button--secondary js-header-login-link'])[2]")
    WebElement signInButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement inputTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='new_password']")
    WebElement passwordNewField;

    @FindBy(xpath = "//input[@id='confirmed_password']")
    WebElement passwordConfirmedField;

    public void acceptCookie(){acceptButton.click();}

    public void registerPage() {
        signInButton.click();
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


    }







