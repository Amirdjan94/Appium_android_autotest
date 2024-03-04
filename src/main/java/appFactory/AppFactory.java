package appFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static data.constance.DesiredCapabilities.*;


public class AppFactory {
    protected static AppiumDriverLocalService service;
    protected DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    protected URL appiumServer;

    @Step("Start appium server")

    public void startServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @Step("Stop appium server")

    public void stopServer() {
        if (service != null) {
            service.stop();
        }
    }

    @Step("Set capability")

    public AppiumDriver setCapability() {
        try {
            desiredCapabilities.setCapability("avd", EMULATOR_NAME);
            desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
            desiredCapabilities.setCapability("automationName", AUTOMATION_NAME);
            desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
            desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
            desiredCapabilities.setCapability("appium:autoGrantPermissions", AUTO_GRANT_PREMISSIONS);
            appiumServer = new URL(SERVER_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AppiumDriver(appiumServer, desiredCapabilities);
    }
}
