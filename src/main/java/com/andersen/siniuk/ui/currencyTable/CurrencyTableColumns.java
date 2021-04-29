package com.andersen.siniuk.ui.currencyTable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CurrencyTableColumns {
    CURRENCY("Currency", "Currency"),
    OFFICIAL_RATE("Official rate", "Official rate"),
    COMPANY_AMOUNT("Company rate", "aysera rate"),
    SWEDBANK_AMOUNT("Swedbank amount", "Swedbank amount"),
    SEB_AMOUNT("SEB amount", "SEB amount"),
    CITADELE_AMOUNT("Citadele amount", "Citadele amount"),
    LUMINOR_AMOUNT("Luminor amount", "Luminor amount"),
    MBANK_AMOUNT("mBank amount", "mBank amount"),
    ING_BANK_AMOUNT("ING Bank amount", "ING Bank amount"),
    UNICREDIT_AMOUNT("Unicredit amount", "Unicredit amount");

    private final String columnName;
    private final String locator;
}
