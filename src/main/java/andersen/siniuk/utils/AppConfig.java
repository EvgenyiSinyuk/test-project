package andersen.siniuk.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:./env.properties"})
public interface AppConfig extends Config {
    @Key("app.url")
    String appUrl();

}
