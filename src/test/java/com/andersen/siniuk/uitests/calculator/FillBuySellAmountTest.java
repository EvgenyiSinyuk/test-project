package com.andersen.siniuk.uitests.calculator;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FillBuySellAmountTest extends BaseCalculatorTest {

    @Test
    @DisplayName("Filling BUY and SELL amounts.")
    @Description("When user fills \"BUY\" amount, \"SELL\" amount box is being emptied and vice versa.")
    public void fillingBuySellAmounts() {
        calculatorPage.open()
                .setSellParam("200")
                .setBuyParam("300")
                .checkSellInputEmpty()
                .setSellParam("1000")
                .checkBuyInputEmpty();
    }
}