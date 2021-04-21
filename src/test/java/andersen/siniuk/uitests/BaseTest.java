package andersen.siniuk.uitests;

import andersen.siniuk.drivers.DriverFactory;
import andersen.siniuk.extensions.JUnitExecutionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(JUnitExecutionExtension.class)
public abstract class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    static void setUpDriver(){
        driver = DriverFactory.getDriver();
    }
}