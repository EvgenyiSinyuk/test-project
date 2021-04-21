package andersen.siniuk.utils;

import andersen.siniuk.drivers.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Actions {

    public static void scrollIntoView(WebElement webElement) {
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
