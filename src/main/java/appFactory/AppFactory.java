package appFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static data.constance.DesiredCapabilities.*;


public class AppFactory {
    protected static AppiumDriverLocalService service;
    protected DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    protected URL appiumServer;

    public void startServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public void stopServer() {
        if (service != null) {
            service.stop();
        }
    }

    public AppiumDriver setCapability() {
        try {
            desiredCapabilities.setCapability("avd", "android_12");
            desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
            desiredCapabilities.setCapability("automationName", AUTOMATION_NAME);
            desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
            desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
            desiredCapabilities.setCapability("appium:autoGrantPermissions", "true");
            appiumServer = new URL(SERVER_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AppiumDriver(appiumServer, desiredCapabilities);
    }
}