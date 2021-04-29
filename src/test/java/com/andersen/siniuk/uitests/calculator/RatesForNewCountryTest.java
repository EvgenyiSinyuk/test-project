package com.andersen.siniuk.uitests.calculator;

import com.andersen.siniuk.countriesInfo.Countries;
import com.andersen.siniuk.countriesInfo.Currencies;
import com.andersen.siniuk.ui.currencyTable.CurrencyTableColumns;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.math.BigDecimal;

public class RatesForNewCountryTest extends BaseCalculatorTest {

    @ParameterizedTest
    @EnumSource(value = Countries.class, names = { "RUSSIA", "POLAND" })
    @DisplayName("Rates must be updated and currency option should be changed for selected country.")
    @Description("When user selects country (select option is in the footer), rates must be updated and currency " +
            "option should be changed to the respective default currency for that country.")
    public void ratesUpdatesForNewCountry(Countries country) {
        calculatorPage.open();
        BigDecimal rateBefore = calculatorPage.getCurrencyRateForColumn(CurrencyTableColumns.COMPANY_AMOUNT, Currencies.USD);

        calculatorPage.selectCountry(country.getCountryName());
        BigDecimal rateAfter = calculatorPage.getCurrencyRateForColumn(CurrencyTableColumns.COMPANY_AMOUNT, Currencies.USD);
        String newCurrency = calculatorPage.getSellCurrency();

        calculatorPage
                .checkRatesUpdated(rateBefore, rateAfter)
                .checkCurrencyChanged(newCurrency, country.getCurrency());
    }
}