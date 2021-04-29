package com.andersen.siniuk.utils;

import lombok.Getter;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

@Getter
public class ConfigReader {

    static Configurations configurations = new Configurations();
    static Configuration configuration;

    static {
        try {
            configuration = configurations.properties(new File("config.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    static String anyConfig = configuration.getString("anyConfig");

}
