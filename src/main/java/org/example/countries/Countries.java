package org.example.countries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Countries {

    RUSSIA("Russia", "-RU", Currencies.RUB),
    LUTHUANIA("Lithuania", "-LT", Currencies.EUR),
    ESTONIA("Estonia", "-EE", Currencies.EUR),
    LATVIA("Latvia", "-LV", Currencies.EUR),
    BULGARIA("Bulgaria", "-BG", Currencies.BGN),
    SPAIN("Spain", "-ES", Currencies.EUR),
    ROMANIA("Romania", "-RO", Currencies.RON),
    POLAND("Poland", "-PL", Currencies.PLN),
    UNITEDKINGDOM("United Kingdom", "-GB", Currencies.GBP),
    GERMANY("Germany", "-DE", Currencies.EUR),
    ALGERIA("Algeria", "-DZ", Currencies.DZD),
    ALBANIA("Albania", "-AL", Currencies.ALL),
    KOSOVO("Kosovo", "-XK", Currencies.EUR),
    UKRAINE("Ukraine", "-UA", Currencies.UAH),
    ANOTHER("Another country", "", Currencies.EUR);

    private final String countryName;
    private final String urlDescriptor;
    private final Currencies currency;

}
