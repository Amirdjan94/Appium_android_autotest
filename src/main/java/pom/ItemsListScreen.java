package pom;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ItemsListScreen {
    public AppiumDriver driver;
    public By basketBtn = AppiumBy.accessibilityId("test-Cart");
    public ItemsListScreen(AppiumDriver driver){
        this.driver = driver;
    }
    public boolean isVisiblebasketBtn(){
        return driver.findElement(basketBtn).isDisplayed();
    }
}
