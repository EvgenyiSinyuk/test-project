package com.andersen.siniuk.ui;

import com.andersen.siniuk.countriesInfo.Currencies;
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

    @FindBy(xpath = "(//span[contains(@class,'flag-icon-us')]/../following-sibling::*)[3]")
    private WebElement usdCompanyAmount;

    @FindBy(xpath = "(//span[contains(@class,'flag-icon-us')]/../following-sibling::*)[4]//span[@class='ng-binding']")
    private WebElement usdSwedBankAmount;

    @FindBy(xpath = "(//span[contains(@class,'flag-icon-us')]/../following-sibling::*)[4]//span[starts-with(@class, 'other-bank-loss')]")
    private WebElement swedBankLoss;

    @FindBy(css = ".js-localization-popover")
    private WebElement localizationPopover;

    @FindBy(id = "countries-dropdown")
    private WebElement countriesDropdown;

    @FindBy(xpath = "(//span[contains(@class,'flag-icon-us')]/../following-sibling::*)[1]")
    private WebElement usdOfficialRate;

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

    @Step("Get USD Company amount")
    public BigDecimal getUSDCompanyAmount() {
        Actions.scrollIntoView(usdCompanyAmount);
        return BigDecimal.valueOf(Double.parseDouble(usdCompanyAmount.getText()));
    }

    @Step("Get USD SwedBank amount")
    public BigDecimal getUSDSwedBankAmount() {
        Actions.scrollIntoView(usdSwedBankAmount);
        return BigDecimal.valueOf(Double.parseDouble(usdSwedBankAmount.getText()));
    }

    @Step("Get SwedBank difference")
    public BigDecimal getCompanySwedBankLoss() {
        Actions.scrollIntoView(swedBankLoss);
        return BigDecimal.valueOf(Double.parseDouble(swedBankLoss.getText().replaceAll("[()^]*", "")));
    }

    @Step("Get USD Official rate")
    public String getUSDOfficialRate() {
        Actions.scrollIntoView(usdOfficialRate);
        return usdOfficialRate.getText();
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
    public BigDecimal getProviderCompanyDiff() {
        final BigDecimal companyAmount = getUSDCompanyAmount();
        final BigDecimal swedBankAmount = getUSDSwedBankAmount();
        return swedBankAmount.subtract(companyAmount);
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
    public CalculatorPage checkRatesUpdated(String rateBefore, String rateAfter) {
        assertNotEquals(rateBefore, rateAfter, "Rates for different countries equals!");
        return this;
    }

    @Step("Check currency option changed according selected country")
    public CalculatorPage checkCurrencyChanged(String newCurrency, Currencies countryCurrency) {
        assertEquals(newCurrency, countryCurrency.toString(), "Wrong currency for this country!");
        return this;
    }

}