import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.ItemsListScreen;
import pom.MainScreen;

public class LoginUserTest extends BaseTest {
    @Test
    @DisplayName("Сheck login standart user via tap standart user button")
    @Description("Check automatic fill input and login standart user")
    public void logInStandartUserViaTapStandartUserBtn() {

        boolean isVisiblebasketBtn = new MainScreen(driver)
                .standartUserBtnClick()
                .loginBtnClickForStandartUser()
                .isVisiblebasketBtn();
        Assertions.assertTrue(isVisiblebasketBtn, "User can't login");

    }

    @Test
    @DisplayName("Сheck login locked out user via tap locked out user button")
    @Description("Check automatic fill input and show error message")
    public void logInLockedOutUserForTapLockedOutUserBtn() {

        boolean isVisibleErrorMessage = new MainScreen(driver)
                .lockedOutUserBtnClick()
                .loginBtnClickForLockedOutUser()
                .isVisibleErrorMessage();
        Assertions.assertTrue(isVisibleErrorMessage, "Error message is not visible");

    }

    @Test
    @DisplayName("Сheck login problem user via tap problem user button")
    @Description("Check automatic fill input and login problem user (without Fluent API)")
    public void logInProblemUserViaTapProblemUserBtn() {

        // I don't used here Fluent API pattern because I want to use "var"
        var mainScreen = new MainScreen(driver);
        driver.findElement(mainScreen.problem_user).click();
        driver.findElement(mainScreen.loginBtn).click();
        Assertions.assertTrue(new ItemsListScreen(driver).isVisiblebasketBtn(), "User can't login");

    }

    @Test
    @DisplayName("Сheck login standart user via fill input")
    @Description("Check manual fill input and login standart user (without Fluent API)")
    public void logInStandartUserViaFillInput() {

        // I don't used here Fluent API pattern because I want to use "var"
        var mainScreen = new MainScreen(driver);
        driver.findElement(mainScreen.userNameInput).sendKeys("standard_user");
        driver.findElement(mainScreen.passwordInput).sendKeys("secret_sauce");
        driver.findElement(mainScreen.loginBtn).click();
        Assertions.assertTrue(new ItemsListScreen(driver).isVisiblebasketBtn());

    }

    @Test
    @DisplayName("Chek login locked out user via fill input")
    @Description("Check manual fill input and login locked out user")
    public void logInLockedOutUserViaFillInput(){
        boolean isVisibleErrorMessage = new MainScreen(driver)
                .fillUsernameInput("locked_out_user")
                .fillPasswordInput("secret_sauce")
                .loginBtnClickForLockedOutUser()
                .isVisibleErrorMessage();
        Assertions.assertAll(
                ()-> Assertions.assertFalse(isVisibleErrorMessage, "Error message is not visible"),
                ()-> Assertions.assertEquals("Sorry, this user has been locked out.", driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]")).getText())
        );

    }
}
