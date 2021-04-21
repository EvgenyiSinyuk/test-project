package andersen.siniuk.uitests.calculator;

import andersen.siniuk.countriesInfo.Countries;
import andersen.siniuk.countriesInfo.Currencies;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RatesForNewCountryTest extends BaseCalculatorTest {

    @ParameterizedTest
    @EnumSource(value = Countries.class, names = { "RUSSIA", "POLAND" })
    @DisplayName("Rates must be updated and currency option should be changed for selected country.")
    @Description("When user selects country (select option is in the footer), rates must be updated and currency " +
            "option should be changed to the respective default currency for that country.")
    public void ratesUpdatesForNewCountry(Countries country) {
        calculatorPage.open();
        String rateBefore = calculatorPage.getUSDOfficialRate();

        calculatorPage.selectCountry(country.getCountryName());
        String rateAfter = calculatorPage.getUSDOfficialRate();
        String newCurrency = calculatorPage.getSellCurrency();

        checkRatesUpdated(rateBefore, rateAfter);
        checkCurrencyChanged(newCurrency, country.getCurrency());
    }

    @Step("Check that counted and displayed are loss equals")
    private void checkRatesUpdated(String rateBefore, String rateAfter) {
        assertNotEquals(rateBefore, rateAfter, "Rates for different countries equals!");
    }

    @Step("Check currency option changed according selected country")
    private void checkCurrencyChanged(String newCurrency, Currencies countryCurrency) {
        assertEquals(newCurrency, countryCurrency.toString(), "Wrong currency for this country!");
    }
}