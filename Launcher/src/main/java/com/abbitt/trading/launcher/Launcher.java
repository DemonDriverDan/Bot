package com.abbitt.trading.launcher;


import com.abbitt.trading.connection.AccountOperations;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Launcher {

    public static void main(String[] args) {
        ConfigurationLoader configLoader = new ConfigurationLoader();
        Injector injector = Guice.createInjector(configLoader);
        AccountOperations accountOperations = injector.getInstance(AccountOperations.class);

        accountOperations.getAccountFunds();
    }
}
