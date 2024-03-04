import data.users.Users;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pom.ItemsListScreen;
import pom.MainScreen;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginUserTest extends BaseTest {
    @Test
    @DisplayName("Сheck login standard user via tap standard user button")
    @Description("Check automatic fill input and login standard user")
    public void logInStandardUserViaTapStandardUserBtn() {

        boolean isVisiblebasketBtn = new MainScreen(driver)
                .standardUserBtnClick()
                .loginBtnClickForStandardUser()
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
        driver.findElement(mainScreen.problemUser).click();
        driver.findElement(mainScreen.loginBtn).click();
        Assertions.assertTrue(new ItemsListScreen(driver).isVisiblebasketBtn(), "User can't login");

    }

    @Test
    @DisplayName("Сheck login standard user via fill input")
    @Description("Check manual fill input and login standard user (without Fluent API)")
    public void logInStandardUserViaFillInput() {

        // I don't used here Fluent API pattern because I want to use "var"
        var mainScreen = new MainScreen(driver);
        var users = new Users();
        driver.findElement(mainScreen.userNameInput).sendKeys(users.getStandardUserUsername());
        driver.findElement(mainScreen.passwordInput).sendKeys(users.getStandardUserPassword());
        driver.findElement(mainScreen.loginBtn).click();
        Assertions.assertTrue(new ItemsListScreen(driver).isVisiblebasketBtn());

    }

    @Test
    @DisplayName("Chek login locked out user via fill input")
    @Description("Check manual fill input and login locked out user")
    public void logInLockedOutUserViaFillInput(){

        boolean isVisibleErrorMessage = new MainScreen(driver)
                .fillUsernameInput(new Users().getLockedOutUsername())
                .fillPasswordInput(new Users().getLockedOutUserPassword())
                .loginBtnClickForLockedOutUser()
                .isVisibleErrorMessage();

        Assertions.assertAll(
                ()-> Assertions.assertTrue(isVisibleErrorMessage, "Error message is not visible"),
                ()-> Assertions.assertEquals("Sorry, this user has been locked out.", new MainScreen(driver).getErrorMessageText(), "Incorrect error message text")
        );

    }

    public static Stream<Arguments> usersTestData(){
        var users = new Users();
        return Stream.of(
                arguments(users.getStandardUserUsername(), users.getStandardUserPassword()),
                arguments(users.getProblemUsername(), users.getProblemUserPassword())
        );
    }
    @ParameterizedTest
    @MethodSource("usersTestData")
    @DisplayName("Chek login standard and problem user via fill input, use parameterized test")
    @Description("Check manual fill input and login correctly users")
    public void logInLockedOutUserViaFillInput(String username, String password){

        boolean isVisiblebasketBtn = new MainScreen(driver)
                .fillUsernameInput(username)
                .fillPasswordInput(password)
                .loginBtnClickForStandardUser()
                .isVisiblebasketBtn();

        Assertions.assertTrue(isVisiblebasketBtn, "User can't login");

    }


}
