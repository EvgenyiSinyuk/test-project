package org.example.countries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Languages {

    RUSSIA("Русский", "ru"),
    LUTHUANIA("Lietuvių", "lt"),
    ESTONIA("Eesti", "ee"),
    LATVIA("Latviešu", "lv"),
    BULGARIA("Български", "bg"),
    SPAIN("Español", "es"),
    ROMANIA("Română", "ro"),
    POLAND("Polski", "pl"),
    ENGLISH("English", "en"),
    GERMANY("Deutsch", "de"),
    SHQIP("Shqip", "sq"),
    KOSOVO("Shqip (Kosovë)", "xk"),
    UKRAINE("Українська", "ua");

    private final String language;
    private final String urlDescriptor;

}
