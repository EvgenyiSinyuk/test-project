package com.andersen.siniuk.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
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
        WebDriver driver;

        if (System.getProperty("browser").equals(Browsers.CHROME.getName())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeCapabilities());
        } else if (System.getProperty("browser").equals(Browsers.FIREFOX.getName())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            log.error("Browser name wrong");
            return null;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}