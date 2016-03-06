package com.abbitt.trading.launcher;


import com.abbitt.trading.connection.BettingOperations;
import com.abbitt.trading.connection.LoginModule;
import com.abbitt.trading.domain.MarketFilter;
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
        LOG.info("Guice initialised");

        LoginModule operations = injector.getInstance(LoginModule.class);
        Injector childInjector = injector.createChildInjector(operations);

        String sessionToken = childInjector.getInstance(Key.get(String.class, Names.named("session.token")));
        if (sessionToken != null) {
            LOG.info("Logged in with session token {}", sessionToken);
        } else {
            LOG.error("Unable to log in");
            System.exit(1);
        }

        BettingOperations bettingOperations = childInjector.getInstance(BettingOperations.class);
        bettingOperations.listEventTypes(MarketFilter.builder.build());

    }
}
