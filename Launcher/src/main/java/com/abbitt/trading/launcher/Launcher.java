package com.abbitt.trading.launcher;


import com.abbitt.trading.connection.BettingOperations;
import com.abbitt.trading.connection.LoginModule;
import com.abbitt.trading.domain.*;
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
        LOG.info("Guice initialised");

        LoginModule loginModule = injector.getInstance(LoginModule.class);
        WebModule webModule = injector.getInstance(WebModule.class);
        Injector childInjector = injector.createChildInjector(loginModule, webModule);

        String sessionToken = childInjector.getInstance(Key.get(String.class, Names.named("session.token")));
        if (sessionToken != null) {
            LOG.info("Logged in with session token {}", sessionToken);
        } else {
            LOG.error("Unable to log in");
            System.exit(1);
        }

        BettingOperations bettingOperations = childInjector.getInstance(BettingOperations.class);
//        List<EventTypeResult> eventTypeResults = bettingOperations.listEventTypes(MarketFilter.builder.build());
//        LOG.info(bettingOperations.listCurrentOrders().getCurrentOrders().size());

        String marketId = "1.123499619";
        MarketFilter.Builder filterBuilder = MarketFilter.builder;
        filterBuilder
                .withEventTypeIds("7");

//        List<EventResult> eventResults = bettingOperations.listEvents(filterBuilder.build());

        PlaceInstruction.Builder builder = PlaceInstruction.builder;
        PlaceInstruction instruction = builder
                .withSelectionId(10078179)
                .withOrderType(OrderType.LIMIT)
                .withSide(Side.BACK)
                .withLimitOrder(new LimitOrder(5, 30, PersistenceType.LAPSE))
                .build();

//        PlaceExecutionReport report = bettingOperations.placeOrders(marketId, Collections.singletonList(instruction), "REF01");
//        LOG.info(report.toString());
    }
}
