package org.example.uitests;

import org.example.drivers.DriverFactory;
import org.example.extensions.JUnitExecutionExtension;
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