package com.abbitt.trading.web;

import com.abbitt.trading.connection.BettingOperations;
import com.abbitt.trading.domain.*;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import spark.Request;
import spark.Response;

import java.util.Collections;

import static spark.Spark.*;


public class WebModule extends AbstractModule {
    private static final Logger LOG = LogManager.getLogger(WebModule.class);
    private static final String EXCEPTION_MESSAGE = "Error while processing request: ";
    private static final String EXCEPTION_MESSAGE_HTML = EXCEPTION_MESSAGE + " <br />";

    private final int port;
    private final BettingOperations bettingOperations;

    @Inject
    public WebModule(@Named("web.port") int port, BettingOperations bettingOperations) {
        this.port = port;
        this.bettingOperations = bettingOperations;
    }

    @Override
    protected void configure() {
        LOG.debug("Initialising Spark with port {}", port);
        port(port);
        exception(Exception.class, (e, req, resp) -> {
            LOG.warn(EXCEPTION_MESSAGE, e);
            resp.status(500);
            resp.body(EXCEPTION_MESSAGE_HTML + e.toString());
        });
        get("/listEventTypes", (req, resp) -> bettingOperations.listEventTypes(new MarketFilter.Builder().build()));
        get("/placeOrder", this::placeBet);
        LOG.debug("Spark initialised");
    }

    private String placeBet(Request req, Response response) {
        String marketId = req.queryMap("marketId").value();
        if (marketId == null) {
            throw new IllegalStateException("No market ID defined");
        }

        PlaceInstruction.Builder builder = new PlaceInstruction.Builder();
        PlaceInstruction instruction = builder
                .withSelectionId(Long.parseLong(req.queryMap("selectionId").value()))
                .withOrderType(OrderType.LIMIT)
                .withSide(Side.valueOf(req.queryMap("side").value()))
                .withLimitOrder(new LimitOrder(req.queryMap("size").doubleValue(),
                                               req.queryMap("price").doubleValue(),
                                               PersistenceType.LAPSE))
                .build();

        String ref = "DAN01";

        return bettingOperations.placeOrders(marketId, Collections.singletonList(instruction), ref).toString();
    }
}
