package andersen.siniuk.countriesInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Languages {

    RUSSIA("Русский"),
    LUTHUANIA("Lietuvių"),
    ESTONIA("Eesti"),
    LATVIA("Latviešu"),
    BULGARIA("Български"),
    SPAIN("Español"),
    ROMANIA("Română"),
    POLAND("Polski"),
    ENGLISH("English"),
    GERMANY("Deutsch"),
    SHQIP("Shqip"),
    KOSOVO("Shqip (Kosovë)"),
    UKRAINE("Українська");

    private final String language;

}
