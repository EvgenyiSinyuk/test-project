package com.andersen.siniuk.uitests.calculator;

import com.andersen.siniuk.uitests.dataProvider.CountryAndBank;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.math.BigDecimal;

public class LossForLowerAmountTest extends BaseCalculatorTest {

    @ParameterizedTest
    @EnumSource(value = CountryAndBank.class, names = { "LITHUANIA", "POLAND", "BULGARIA" })
    @DisplayName("Loss displayed when provider's exchange amount lower")
    @Description("When bank provider's exchange amount for selling (X) is lower than the amount, " +
            "provided by Company (Y), then a text box is displayed, representing the loss (X-Y)")
    public void lowerLossDisplayed(CountryAndBank data) {
        calculatorPage.open();
        calculatorPage.selectCountry(data.getCountry().getCountryName());

        BigDecimal providerCompanyDiff = calculatorPage.getProviderCompanyDiff(data.getBank(), data.getCurrencyToCheck());
        calculatorPage
                .checkCompanyAmountLower(providerCompanyDiff)
                .checkDisplayedLoss(calculatorPage.getCurrencyLossForColumn(data.getBank(), data.getCurrencyToCheck()), providerCompanyDiff);
    }
}
