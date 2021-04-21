package andersen.siniuk.uitests.calculator;

import andersen.siniuk.ui.CalculatorPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FillBuySellAmountTest extends BaseCalculatorTest {
    @Test
    @DisplayName("Filling BUY and SELL amounts.")
    @Description("When user fills \"BUY\" amount, \"SELL\" amount box is being emptied and vice versa.")
    public void fillingBuySellAmounts() {
        calculatorPage.open()
                .setSellParam("200")
                .setBuyParam("300");
        checkSellInputEmpty();

        calculatorPage.setSellParam("1000");
        checkBuyInputEmpty();

    }

    @Step("Check that sell input empty")
    public void checkSellInputEmpty() {
        Assertions.assertEquals(CalculatorPage.getSellParam(), StringUtils.EMPTY);
    }

    @Step("Check that buy input empty")
    public void checkBuyInputEmpty() {
        assertEquals(CalculatorPage.getBuyParam(), StringUtils.EMPTY);
    }
}