import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pom.ItemsListScreen;
import pom.MainScreen;


public class LoginUserTest extends BaseTest {
    @Test
    public void logInUserForFillInput() {

        MainScreen mainScreen = new MainScreen();
        driver.findElement(mainScreen.standard_userBtn).click();
        driver.findElement(mainScreen.loginBtn).click();

        Assertions.assertTrue(new ItemsListScreen(driver).isVisiblebasketBtn());

    }
}
