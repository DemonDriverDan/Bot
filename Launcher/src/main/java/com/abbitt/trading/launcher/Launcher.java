package com.abbitt.trading.launcher;


import com.abbitt.trading.web.WebModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {
    private static final Logger LOG = LogManager.getLogger(Launcher.class);

    public static void main(String[] args) {
        LOG.info("Starting bot...");
        Injector injector = Guice.createInjector(new ConfigModule());

        WebModule webModule = injector.getInstance(WebModule.class);
        Injector childInjector = injector.createChildInjector(webModule);

        String sessionToken = childInjector.getInstance(Key.get(String.class, Names.named("session.token")));
        if (sessionToken != null) {
            LOG.info("Logged in with session token {}", sessionToken);
        } else {
            LOG.error("Unable to log in");
            System.exit(1);
        }
        LOG.info("Guice initialised");
    }
}
