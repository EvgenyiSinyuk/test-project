package com.andersen.siniuk.uitests;

import com.andersen.siniuk.drivers.DriverFactory;
import com.andersen.siniuk.extensions.JUnitExecutionExtension;
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