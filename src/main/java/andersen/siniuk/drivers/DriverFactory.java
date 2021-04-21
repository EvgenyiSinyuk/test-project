package andersen.siniuk.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getPreparedDriver();
        }
        return driver;
    }

    private static ChromeOptions getChromeCapabilities() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }

    private static WebDriver getPreparedDriver() {
        if (System.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();

            WebDriver chromeDriver = new ChromeDriver(getChromeCapabilities());

            chromeDriver.manage().window().maximize();
            chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return chromeDriver;
        } else {
            System.err.println("Browser name wrong");
            return null;
        }
    }
}