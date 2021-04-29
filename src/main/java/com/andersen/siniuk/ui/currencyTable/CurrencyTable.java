package com.andersen.siniuk.ui.currencyTable;

import com.andersen.siniuk.countriesInfo.Currencies;
import com.andersen.siniuk.ui.BasePage;
import org.openqa.selenium.WebDriver;

public class CurrencyTable extends BasePage  {

    public CurrencyTable(WebDriver driver) {
        super(driver);
    }

    public String getBankRateForCountry(CurrencyTableColumns bank, Currencies currency) {
        return new CurrencyTableRow(driver).getBankRate(bank, currency);
    }

    public String getBankLossForCountry(CurrencyTableColumns bank, Currencies currency) {
        return new CurrencyTableRow(driver).getBankLoss(bank, currency);
    }
}
