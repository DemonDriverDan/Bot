package com.abbitt.trading.launcher;


import com.abbitt.trading.connection.LoginModule;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigModule extends AbstractModule {

    private static final Logger LOG = LogManager.getLogger(ConfigModule.class);

    @Override
    protected void configure() {
        Properties props = new Properties();

        String configLocation = System.getProperty("configLocation");
        if (configLocation == null || configLocation.isEmpty()) {
            throw new RuntimeException("No config location defined, specify the system property 'config.location'");
        }

        try {
            // TODO Switch to use Launcher.class.getResourceAsStream?
            props.load(new FileReader(configLocation));
            Names.bindProperties(binder(), props);
            bindSsoToken(props);
        } catch (IOException e) {
            LOG.error("Error loading config file", e);
            throw new RuntimeException(e);
        }
    }

    private void bindSsoToken(Properties props) {
        String ssoToken = LoginModule.login(props.getProperty("key.location"),
                                            props.getProperty("key.password"),
                                            props.getProperty("account.login"),
                                            props.getProperty("account.password"),
                                            props.getProperty("api.key"));
        bindConstant().annotatedWith(Names.named("session.token")).to(ssoToken);
    }
}
