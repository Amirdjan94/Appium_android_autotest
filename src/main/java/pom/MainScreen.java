package pom;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MainScreen {
    public By userNameInput = AppiumBy.accessibilityId("test-Username");
    public By passwordInput = AppiumBy.accessibilityId("test-Password");
    public By loginBtn = AppiumBy.accessibilityId("test-LOGIN");
    public By standard_userBtn = AppiumBy.accessibilityId("test-standard_user");
    public By locked_out_user = AppiumBy.accessibilityId("test-locked_out_user");
    public By problem_user = AppiumBy.accessibilityId("test-problem_user");

}
