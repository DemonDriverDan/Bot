package com.abbitt.trading.launcher;


import com.google.inject.Guice;
import com.google.inject.Injector;

public class Launcher {

    public static void main(String[] args) {
        ConfigurationLoader configLoader = new ConfigurationLoader();
        Injector injector = Guice.createInjector(configLoader);
//        injector.getInstance(Test.class);
    }
}
