package com.andersen.siniuk.uitests.dataProvider;

import com.andersen.siniuk.countriesInfo.Countries;
import com.andersen.siniuk.countriesInfo.Currencies;
import com.andersen.siniuk.ui.currencyTable.CurrencyTableColumns;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryAndBank {

    LITHUANIA(Countries.LITHUANIA, CurrencyTableColumns.SWEDBANK_AMOUNT, Currencies.USD),
    BULGARIA(Countries.BULGARIA, CurrencyTableColumns.UNICREDIT_AMOUNT, Currencies.EUR),
    POLAND(Countries.POLAND, CurrencyTableColumns.ING_BANK_AMOUNT, Currencies.EUR);

    private final Countries country;
    private final CurrencyTableColumns bank;
    private final Currencies currencyToCheck;

}
