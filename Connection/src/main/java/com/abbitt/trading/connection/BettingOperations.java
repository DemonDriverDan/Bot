package com.abbitt.trading.connection;


import com.abbitt.trading.domain.EventResult;
import com.abbitt.trading.domain.EventTypeResult;
import com.abbitt.trading.domain.MarketFilter;
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
    private static final String LIST_EVENT_TYPES = "listEventTypes/";
    private static final String LIST_EVENTS = "listEvents/";

    @Inject
    public BettingOperations(@Named("api.key") String apiKey, @Named("betting.url") String urlBase,
                             @Named("session.token") String ssoToken) {
        super(apiKey, urlBase, ssoToken);
    }

    public List<EventTypeResult> listEventTypes(MarketFilter filter) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(FILTER, filter);

        LOG.debug("Requesting event types");
        String response = makeRequest(LIST_EVENT_TYPES, params);
        return gson.fromJson(response, new TypeToken<ArrayList<EventTypeResult>>() {}.getType());
    }

    public List<EventResult> listEvents(MarketFilter filter) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(FILTER, filter);

        LOG.debug("Requesting events");
        String response = makeRequest(LIST_EVENTS, params);
        return gson.fromJson(response, new TypeToken<ArrayList<EventResult>>() {}.getType());
    }


}
