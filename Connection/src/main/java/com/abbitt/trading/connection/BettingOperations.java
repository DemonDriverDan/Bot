package com.abbitt.trading.connection;


import com.abbitt.trading.domain.*;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BettingOperations extends OperationsBase {
    private static final Logger LOG = LogManager.getLogger(BettingOperations.class);

    private static final String FILTER = "filter";
    private static final String MARKET_ID = "marketId";
    private static final String CUSTOMER_REF = "customerRef";
    private static final String INSTRUCTIONS = "instructions";

    private static final String LIST_EVENT_TYPES = "listEventTypes/";
    private static final String LIST_EVENTS = "listEvents/";
    private static final String LIST_CURRENT_ORDERS = "listCurrentOrders/";
    private static final String PLACE_ORDERS = "placeOrders/";
    private static final String CANCEL_ORDERS = "cancelOrders/";

    @Inject
    public BettingOperations(@Named("api.key") String apiKey, @Named("betting.url") String urlBase,
                             @Named("session.token") String ssoToken) {
        super(apiKey, urlBase, ssoToken);
    }

    public List<EventTypeResult> listEventTypes(MarketFilter filter) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(FILTER, filter);

        String response = makeRequest(LIST_EVENT_TYPES, params);
        return gson.fromJson(response, new TypeToken<ArrayList<EventTypeResult>>() {}.getType());
    }

    public List<EventResult> listEvents(MarketFilter filter) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(FILTER, filter);

        String response = makeRequest(LIST_EVENTS, params);
        return gson.fromJson(response, new TypeToken<ArrayList<EventResult>>() {}.getType());
    }

    public CurrentOrderSummaryReport listCurrentOrders() {
        String response = makeRequest(LIST_CURRENT_ORDERS, getParamsWithLocale());
        return gson.fromJson(response, CurrentOrderSummaryReport.class);
    }

    public PlaceExecutionReport placeOrders(String marketId, List<PlaceInstruction> placeInstructions, String customerRef) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(MARKET_ID, marketId);
        params.put(INSTRUCTIONS, placeInstructions);
        if (null != customerRef && !customerRef.isEmpty()) {
            params.put(CUSTOMER_REF, customerRef);
        }

        String response = makeRequest(PLACE_ORDERS, params);
        return gson.fromJson(response, PlaceExecutionReport.class);
    }

    public CancelExecutionReport cancelOrders(String marketId, List<CancelInstruction> instructions, String customerRef) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(MARKET_ID, marketId);
        params.put(INSTRUCTIONS, instructions);
        if (null != customerRef && !customerRef.isEmpty()) {
            params.put(CUSTOMER_REF, customerRef);
        }

        String response = makeRequest(CANCEL_ORDERS, params);
        return gson.fromJson(response, CancelExecutionReport.class);
    }
}
