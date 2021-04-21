package andersen.siniuk.uitests.calculator;

import andersen.siniuk.ui.CalculatorPage;
import andersen.siniuk.uitests.BaseTest;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseCalculatorTest extends BaseTest {

    public CalculatorPage calculatorPage;

    @BeforeEach
    public void setUp(){
        calculatorPage = new CalculatorPage(driver);
    }
}