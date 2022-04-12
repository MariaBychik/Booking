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

import static org.testng.Assert.assertEquals;

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

    public void acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='onetrust-banner-sdk']")));
            acceptButton.click();
        }
        catch(TimeoutException e) {

        }
    }

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

    public void confirm(){
        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(driver -> driver.findElement(By.xpath("//span[@id='profile-menu-trigger--title']")));
        assertEquals(confirm.getText().contains("Your account"), true);
    }

    }







