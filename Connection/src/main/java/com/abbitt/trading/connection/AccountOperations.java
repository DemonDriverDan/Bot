package com.abbitt.trading.connection;


import com.abbitt.trading.domain.AccountFundsResponse;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AccountOperations extends OperationsBase {
    private static final Logger LOG = LogManager.getLogger(AccountOperations.class);
    private static final String WALLET = "wallet";
    private static final String UK_WALLET = "UK";
    private static final String ACCOUNT_FUNDS = "getAccountFunds/";

    @Inject
    public AccountOperations(@Named("api.key") String apiKey, @Named("account.url") String urlBase,
                             @Named("session.token") String ssoToken) {
        super(apiKey, urlBase, ssoToken);
    }

    public AccountFundsResponse getAccountFunds() {
        Map<String, Object> params = new HashMap<>(1);
        params.put(WALLET, UK_WALLET);

        String responseString = makeRequest(ACCOUNT_FUNDS, params);
        LOG.info("Response received for funds request {}", responseString);
        AccountFundsResponse response = gson.fromJson(responseString, AccountFundsResponse.class);
        LOG.info("Account funds: {}", response.toString());

        return response;
    }
}
