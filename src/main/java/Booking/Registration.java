package Booking;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration {
    public WebDriver driver;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptButton;

    @FindBy(xpath = "(//a[@class='bui-button bui-button--secondary js-header-login-link'])[2]")
    WebElement signInButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement inputTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//input[@name='new_password']")
    WebElement passwordNewField;

    @FindBy(xpath = "//input[@name='confirmed_password']")
    WebElement passwordConfirmedField;

    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']")
    WebElement bannerAccept;

    @FindBy(xpath = "//p[@id='HSUgawEDeZzEKyk']")
    WebElement pressHoldButton;

    public Registration(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Accepting cookies if they exist on the page")
    public Registration acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(bannerAccept));
            acceptButton.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return  this;
    }

    public Registration switchToRegisterPage() {signInButton.click();
        return this;
    }

    @Step("Fill in email: {0}")
    public Registration inputEmail(String email) {
        inputTextBox.sendKeys(email);
        return this;
    }

    @Step("Click Continue button")
    public Registration continueRegistration() {
        continueButton.click();
        return this;
    }

    @Step("Fill in new password: {0}")
    public Registration enterNewPassword(String passwordNew) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(passwordNewField));
        passwordNewField.sendKeys(passwordNew);
        return this;
    }

    @Step("Fill in confirmed password: {0}")
    public Registration enterConfirmedPassword(String passwordConfirmed) {
        passwordConfirmedField.sendKeys(passwordConfirmed);
        return this;
    }

    @Step("Click and press confirmation button")
    public Registration confirmRegistration() {
        continueButton.click();
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(pressHoldButton));
            Actions actions = new Actions(driver);
            actions.clickAndHold(pressHoldButton).perform();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
            return this;
    }

    @Step("Verify that user is logged in")
    public boolean isUserLoggedIn(){
        WebElement accountLink = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(By.xpath("//span[@id='profile-menu-trigger--title']")));
        return accountLink.getText().contains("Your account");
    }

    public Registration returnHomePage() {
        driver.navigate().to("https://www.booking.com");
        return this;
    }
 }







