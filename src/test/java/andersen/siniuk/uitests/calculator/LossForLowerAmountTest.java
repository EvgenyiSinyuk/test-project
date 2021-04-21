package andersen.siniuk.uitests.calculator;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LossForLowerAmountTest extends BaseCalculatorTest {

    @Test
    @DisplayName("Loss displayed when provider's exchange amount lower")
    @Description("When bank provider's exchange amount for selling (X) is lower than the amount, " +
            "provided by Company (Y), then a text box is displayed, representing the loss (X-Y)")
    public void lowerLossDisplayed() {
        calculatorPage.open();
        BigDecimal providerCompanyDiff = calculatorPage.getProviderCompanyDiff();
        checkCompanyAmountLower(providerCompanyDiff);
        checkDisplayedLoss(calculatorPage.getCompanySwedBankLoss(), providerCompanyDiff);
    }

    @Step("Check that Company's amount is lower than Provider's amount")
    private void checkCompanyAmountLower(BigDecimal providerCompanyDiff) {
        assertTrue(providerCompanyDiff.compareTo(BigDecimal.ZERO) < 0, "Company's amount is higher or same as Provider's amount!");
    }

    @Step("Check that counted and displayed are loss equals")
    private void checkDisplayedLoss(BigDecimal displayedLoss, BigDecimal providerCompanyDiff) {
        assertEquals(displayedLoss, providerCompanyDiff, "Counted and displayed loss are not equals!");
    }
}