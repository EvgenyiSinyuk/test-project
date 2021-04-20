package org.example.uitests.calculator;

import org.example.uitests.BaseTest;
import org.example.ui.CalculatorPage;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseCalculatorTest extends BaseTest {

    public CalculatorPage calculatorPage;

    @BeforeEach
    public void setUp(){
        calculatorPage = new CalculatorPage(driver);
    }
}