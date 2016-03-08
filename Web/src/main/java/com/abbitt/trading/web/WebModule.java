package com.abbitt.trading.web;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static spark.Spark.get;
import static spark.Spark.port;


public class WebModule extends AbstractModule {
    private static final Logger LOG = LogManager.getLogger(WebModule.class);

    private final int port;

    @Inject
    public WebModule(@Named("web.port") int port) {
        this.port = port;
    }

    @Override
    protected void configure() {
        LOG.debug("Initialising spark with port {}", port);
        port(port);
        get("/hello", (req, resp) -> "Hello World");
        LOG.debug("Initialised hello");
    }
}
