import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pom.ItemsListScreen;
import pom.MainScreen;

public class LoginUserTest extends BaseTest {
    @Test
    @DisplayName("#1 Сheck login user")
    @Description("Basic test for login user in app")

    public void logInUserForFillInput() {

        MainScreen mainScreen = new MainScreen();
        driver.findElement(mainScreen.standard_userBtn).click();
        driver.findElement(mainScreen.loginBtn).click();
        Assertions.assertTrue(new ItemsListScreen(driver).isVisiblebasketBtn());

    }
}
