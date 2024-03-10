import appFactory.AppFactory;
import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver driver;
    AppFactory appFactory = new AppFactory();

    @BeforeClass
    public void initServer() {
        appFactory.startServer();
    }

    @BeforeEach
    public void initApp() {
        driver = appFactory.setCapability();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDownApp() {
        driver.quit();
    }

    @AfterClass
    public void tearDownServer() {
        appFactory.stopServer();
    }
}
