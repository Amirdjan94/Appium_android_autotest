package pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainScreen {
    public AppiumDriver driver;
    public By userNameInput = AppiumBy.accessibilityId("test-Username");
    public By passwordInput = AppiumBy.accessibilityId("test-Password");
    public By loginBtn = AppiumBy.accessibilityId("test-LOGIN");
    public By standardUserBtn = AppiumBy.accessibilityId("test-standard_user");
    public By locked_out_user = AppiumBy.accessibilityId("test-locked_out_user");
    public By problem_user = AppiumBy.accessibilityId("test-problem_user");
    //test-Error message
    public By error_message = AppiumBy.accessibilityId("test-Error message");
    public By errorMessageText = AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]");

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Check show error message")
    public boolean isVisibleErrorMessage() {
        return driver.findElement(error_message).isDisplayed();
    }

    @Step("Click standart user button for fill input \"Username\" and \"Password\"")
    public MainScreen standartUserBtnClick() {
        driver.findElement(standardUserBtn).click();
        return this;
    }

    @Step("Click locked out user button for fill input \"Username\" and \"Password\"")
    public MainScreen lockedOutUserBtnClick() {
        driver.findElement(locked_out_user).click();
        return this;
    }

    @Step("Click problem user button for fill input \"Username\" and \"Password\"")
    public MainScreen problemUserBtnClick() {
        driver.findElement(problem_user).click();
        return this;
    }

    @Step("Click login button click")
    public MainScreen loginBtnClickForLockedOutUser() {
        driver.findElement(loginBtn).click();
        return this;
    }

    @Step("Click login button")
    public ItemsListScreen loginBtnClickForStandartUser() {
        driver.findElement(loginBtn).click();
        return new ItemsListScreen(driver);
    }
    @Step("Fill username in username input")
    public MainScreen fillUsernameInput(String userName){
        driver.findElement(userNameInput).sendKeys(userName);
        return this;
    }
    @Step("Fill password in password input")
    public MainScreen fillPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
}
