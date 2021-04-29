package com.andersen.siniuk.ui.currencyTable;

import com.andersen.siniuk.countriesInfo.Currencies;
import com.andersen.siniuk.drivers.DriverFactory;
import com.andersen.siniuk.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class CurrencyTableRow extends BasePage {

    private final String rateLocatorTemplate = "//span[contains(@class, '%1$s')]/../following-sibling::td[contains(@data-title,'%2$s')]//span[@class='ng-binding']";
    private final String lossLocatorTemplate = "//span[contains(@class, '%1$s')]/../following-sibling::td[contains(@data-title,'%2$s')]//span[contains(@class, 'other-bank-loss')]";

    public CurrencyTableRow(WebDriver driver) {
        super(driver);
    }

    public String getBankRate(CurrencyTableColumns bank, Currencies currency) {
        By locator = By.xpath(String.format(rateLocatorTemplate, currency.toString().toLowerCase().substring(0, 2), bank.getLocator()));
        WebElement rate = DriverFactory.getDriver().findElement(locator);
        return rate.getText().trim();
    }

    public String getBankLoss(CurrencyTableColumns bank, Currencies currency) {
        By locator = By.xpath(String.format(lossLocatorTemplate, currency.toString().toLowerCase().substring(0, 2), bank.getLocator()));
        WebElement rate = DriverFactory.getDriver().findElement(locator);
        String loss = rate.getText().trim();
        return loss.substring(1, loss.length() - 1);
    }
}
