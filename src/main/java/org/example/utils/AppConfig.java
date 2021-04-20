package org.example.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:./env.properties"})
public interface AppConfig extends Config {
    @Key("calculator_url")
    String calculatorUrl();

    @Key("api_version")
    String apiVersion();

}
