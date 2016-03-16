package com.abbitt.trading.connection.stream;


import com.abbitt.trading.domain.stream.AuthenticationMessage;
import com.abbitt.trading.domain.stream.ConnectionResponse;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class StreamOperations {
    private static final Logger LOG = LogManager.getLogger(StreamOperations.class);

    private final String apiKey;
    private final StreamIO streamIO;
    private final Gson gson = new Gson();

    @Inject
    public StreamOperations(@Named("api.key") String apiKey) throws IOException {
        this.apiKey = apiKey;
        this.streamIO = new StreamIO();
        streamIO.initConnection();
    }

    public void authenticate() throws IOException {
        String response = streamIO.sendMessage(new AuthenticationMessage(apiKey));
        ConnectionResponse connectionResponse = gson.fromJson(response, ConnectionResponse.class);
        LOG.debug("Authentication response {}", connectionResponse);
    }

    public void close() {
        streamIO.close();
    }
}
