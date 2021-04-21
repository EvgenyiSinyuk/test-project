package andersen.siniuk.countriesInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Countries {

    RUSSIA("Russia", Currencies.RUB),
    LUTHUANIA("Lithuania", Currencies.EUR),
    ESTONIA("Estonia", Currencies.EUR),
    LATVIA("Latvia", Currencies.EUR),
    BULGARIA("Bulgaria", Currencies.BGN),
    SPAIN("Spain", Currencies.EUR),
    ROMANIA("Romania", Currencies.RON),
    POLAND("Poland", Currencies.PLN),
    UNITEDKINGDOM("United Kingdom", Currencies.GBP),
    GERMANY("Germany", Currencies.EUR),
    ALGERIA("Algeria", Currencies.DZD),
    ALBANIA("Albania", Currencies.ALL),
    KOSOVO("Kosovo", Currencies.EUR),
    UKRAINE("Ukraine", Currencies.UAH),
    ANOTHER("Another country", Currencies.EUR);

    private final String countryName;
    private final Currencies currency;

}
