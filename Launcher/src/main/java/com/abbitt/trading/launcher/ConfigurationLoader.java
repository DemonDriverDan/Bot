package com.abbitt.trading.launcher;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader extends AbstractModule {

    private static final Logger LOG = LogManager.getLogger(ConfigurationLoader.class);

    @Override
    protected void configure() {
        Properties props = new Properties();

        String configLocation = System.getProperty("configLocation");
        if (configLocation == null || configLocation.isEmpty()) {
            throw new RuntimeException("No config location defined, specify the system property 'config.location'");
        }

        try {
            props.load(new FileReader(configLocation));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            LOG.error("Error loading config file", e);
            throw new RuntimeException(e);
        }
    }

}
