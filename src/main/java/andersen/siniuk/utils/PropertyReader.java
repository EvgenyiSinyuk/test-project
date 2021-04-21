package andersen.siniuk.utils;

import org.aeonbits.owner.ConfigFactory;

public class PropertyReader {

    private static AppConfig config;

    public static AppConfig getConf() {
        if (config == null) {
            config = ConfigFactory.create(AppConfig.class);
        }
        return config;
    }
}
