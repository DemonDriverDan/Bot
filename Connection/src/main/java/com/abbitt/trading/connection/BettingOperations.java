package com.abbitt.trading.connection;


import com.abbitt.trading.domain.MarketFilter;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class BettingOperations extends OperationsBase {
    private static final Logger LOG = LogManager.getLogger(BettingOperations.class);

    private static final String FILTER = "filter";
    private static final String LIST_EVENT_TYPES = "listEventTypes/";

    @Inject
    public BettingOperations(@Named("api.key") String apiKey, @Named("betting.url") String urlBase,
                             @Named("session.token") String ssoToken) {
        super(apiKey, urlBase, ssoToken);
    }

    public void listEventTypes(MarketFilter filter) {
        Map<String, Object> params = getParamsWithLocale();
        params.put(FILTER, filter);

        LOG.debug("Requesting event types");
        String response = makeRequest(LIST_EVENT_TYPES, params);
        LOG.debug("Response {}", response);
    }
}
