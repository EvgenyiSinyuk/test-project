package com.andersen.siniuk.uitests.calculator;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class LossForLowerAmountTest extends BaseCalculatorTest {

    @Test
    @DisplayName("Loss displayed when provider's exchange amount lower")
    @Description("When bank provider's exchange amount for selling (X) is lower than the amount, " +
            "provided by Company (Y), then a text box is displayed, representing the loss (X-Y)")
    public void lowerLossDisplayed() {
        calculatorPage.open();
        BigDecimal providerCompanyDiff = calculatorPage.getProviderCompanyDiff();
        calculatorPage
                .checkCompanyAmountLower(providerCompanyDiff)
                .checkDisplayedLoss(calculatorPage.getCompanySwedBankLoss(), providerCompanyDiff);
    }
}
