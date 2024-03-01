import appFactory.AppFactory;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver driver;
    AppFactory appFactory = new AppFactory();

    @BeforeEach
    public void init() {
        appFactory.startServer();
        driver = appFactory.setCapability();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        appFactory.stopServer();
    }
}
