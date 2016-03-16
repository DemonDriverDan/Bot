package com.abbitt.trading.connection.stream;

import com.abbitt.trading.domain.stream.RequestMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class StreamBase {
    private static final Logger LOG = LogManager.getLogger(StreamBase.class);
    private static final String URL = "stream-api.betfair.com";
    private static final int PORT = 443;
    private static final byte[] CRLF = "\r\n".getBytes(StandardCharsets.UTF_8);

    private Socket socket;
    private BufferedReader reader;
    private OutputStream output;
    private long messageCounter = 0;

    public void initConnection() throws IOException {
        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(URL, PORT);
        socket.addHandshakeCompletedListener(event -> LOG.debug("SSL connection created {}", event));
        socket.startHandshake();
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = socket.getOutputStream();
    }

    protected void sendMessage(RequestMessage message) {
        
    }

    private void sendLine(byte[] bytes) throws IOException {
        byte[] combined = addClrf(bytes);
        output.write(combined);
        output.flush();
    }

    private byte[] addClrf(byte[] bytes) {
        byte[] combined = new byte[bytes.length + CRLF.length];
        System.arraycopy(bytes, 0, combined, 0, bytes.length);
        System.arraycopy(CRLF, 0, combined, bytes.length, CRLF.length);
        return combined;
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            LOG.error("Unable to close socket connection", e);
        }
    }
}
