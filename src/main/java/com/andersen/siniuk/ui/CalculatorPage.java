package com.andersen.siniuk.ui;

import com.andersen.siniuk.countriesInfo.Currencies;
import com.andersen.siniuk.ui.currencyTable.CurrencyTable;
import com.andersen.siniuk.ui.currencyTable.CurrencyTableColumns;
import com.andersen.siniuk.utils.Actions;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-ng-model='currencyExchangeVM.filter.to_amount']")
    private static WebElement buyInput;

    @FindBy(xpath = "//input[@data-ng-model='currencyExchangeVM.filter.from_amount']")
    private static WebElement sellInput;

    @FindBy(css = ".js-localization-popover")
    private WebElement localizationPopover;

    @FindBy(id = "countries-dropdown")
    private WebElement countriesDropdown;

    @FindBy(xpath = "//div[contains(@class, 'ui-select-match')]")
    private WebElement sellCurrency;

    @Step("Open calculator page")
    public CalculatorPage open(){
        driver.get(System.getProperty("siteUrl"));
        return this;
    }

    @Step("Get BUY input value")
    public static String getBuyParam() {
        return buyInput.getAttribute("value");
    }

    @Step("Get SELL input value")
    public static String getSellParam() {
        return sellInput.getAttribute("value");
    }

    @Step("Set BUY input value")
    public CalculatorPage setBuyParam(String value) {
        buyInput.clear();
        buyInput.sendKeys(value);
        return this;
    }

    @Step("Set SELL input value")
    public CalculatorPage setSellParam(String value) {
        sellInput.clear();
        sellInput.sendKeys(value);
        return this;
    }

    @Step("Get SELL currency")
    public String getSellCurrency() {
        Actions.scrollIntoView(sellCurrency);
        return sellCurrency.getText();
    }

    @Step("Select country")
    public CalculatorPage selectCountry(String country) {
        localizationPopover.click();
        countriesDropdown.click();
        driver.findElement(By.linkText(country)).click();
        return new CalculatorPage(driver);
    }


    @Step("Get diff between Company's and Provider's amounts")
    public BigDecimal getProviderCompanyDiff(CurrencyTableColumns bank, Currencies currencyToCheck) {
        final BigDecimal companyAmount = getCurrencyRateForColumn(CurrencyTableColumns.COMPANY_AMOUNT, currencyToCheck);;
        final BigDecimal bankAmount = getCurrencyRateForColumn(bank, currencyToCheck);
        return bankAmount.subtract(companyAmount);
    }

    @Step("Check that sell input empty")
    public CalculatorPage checkSellInputEmpty() {
        Assertions.assertEquals(CalculatorPage.getSellParam(), StringUtils.EMPTY);
        return this;
    }

    @Step("Check that buy input empty")
    public CalculatorPage checkBuyInputEmpty() {
        assertEquals(CalculatorPage.getBuyParam(), StringUtils.EMPTY);
        return this;
    }

    @Step("Check that Company's amount is lower than Provider's amount")
    public CalculatorPage checkCompanyAmountLower(BigDecimal providerCompanyDiff) {
        assertTrue(providerCompanyDiff.compareTo(BigDecimal.ZERO) < 0, "Company's amount is higher or same as Provider's amount!");
        return this;
    }

    @Step("Check that counted and displayed are loss equals")
    public CalculatorPage checkDisplayedLoss(BigDecimal displayedLoss, BigDecimal providerCompanyDiff) {
        assertEquals(displayedLoss, providerCompanyDiff, "Counted and displayed loss are not equals!");
        return this;
    }

    @Step("Check that counted and displayed are loss equals")
    public CalculatorPage checkRatesUpdated(BigDecimal rateBefore, BigDecimal rateAfter) {
        assertNotEquals(rateBefore, rateAfter, "Rates for different countries equals!");
        return this;
    }

    @Step("Check currency option changed according selected country")
    public CalculatorPage checkCurrencyChanged(String newCurrency, Currencies countryCurrency) {
        assertEquals(newCurrency, countryCurrency.toString(), "Wrong currency for this country!");
        return this;
    }

    @Step("Get currency rate for bank")
    public BigDecimal getCurrencyRateForColumn(CurrencyTableColumns bank, Currencies currency) {
        return new BigDecimal(new CurrencyTable(driver).getBankRateForCountry(bank, currency).replaceAll(",", ""));
    }

    @Step("Get currency loss for bank")
    public BigDecimal getCurrencyLossForColumn(CurrencyTableColumns bank, Currencies currency) {
        return new BigDecimal(new CurrencyTable(driver).getBankLossForCountry(bank, currency).replaceAll(",", ""));
    }

}