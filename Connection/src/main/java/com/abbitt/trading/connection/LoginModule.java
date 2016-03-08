package com.abbitt.trading.connection;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginModule {
    private static final Logger LOG = LogManager.getLogger(LoginModule.class);
    private static final String LOGIN_URL = "https://identitysso.betfair.com/api/certlogin";

    public static String login(String keyLocation, String keyPassword, String accountLogin, String accountPassword, String apiKey) {
        HttpClient client;

        try {
            SSLContext context = SSLContext.getInstance("TLS");
            KeyManager[] keyManagers = getKeyManagers(keyPassword, keyLocation);
            context.init(keyManagers, null, new SecureRandom());
            SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(context, new DefaultHostnameVerifier());
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            clientBuilder.setSSLSocketFactory(sslConnectionFactory);

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("https", sslConnectionFactory)
                    .build();

            HttpClientConnectionManager clientConnectionManager = new BasicHttpClientConnectionManager(registry);
            clientBuilder.setConnectionManager(clientConnectionManager);

            client = clientBuilder.build();

            HttpPost post = new HttpPost(LOGIN_URL);
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("username", accountLogin));
            nvps.add(new BasicNameValuePair("password", accountPassword));

            post.setEntity(new UrlEncodedFormEntity(nvps));
            post.setHeader("X-Application",apiKey);

            LOG.info("Logging in...");

            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseString = EntityUtils.toString(entity);

                return parseResponseString(responseString);
            } else {
                LOG.warn("Login response was null");
            }

        } catch (Exception e) {
            //TODO Log
            e.printStackTrace();
        }

        return null;
    }

    private static KeyManager[] getKeyManagers(String keyPassword, String keyLocation) throws Exception {
        char[] pwdArray = keyPassword.toCharArray();
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new FileInputStream(keyLocation), pwdArray);
        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore, pwdArray);
        return factory.getKeyManagers();
    }

    private static String parseResponseString(String responseString) {
        // {"sessionToken":"YfwRrPQe1HTL25fWvLhivrelw+e8eIPPRf0Kf66KWds=","loginStatus":"SUCCESS"}
        Pattern pattern = Pattern.compile(".*\"loginStatus\":\"(\\w+)\".*");
        Matcher matcher = pattern.matcher(responseString);

        if (matcher.find()) {
            String loginStatus = matcher.group(1);

            if ("SUCCESS".equals(loginStatus)) {
                return parseSessionToken(responseString);
            }
            LOG.error("Unsuccessful login, status {}", loginStatus);
        } else {
            LOG.error("Unable to parse login status from response string {}", responseString);
        }

        return null;
    }

    private static String parseSessionToken(String responseString) {
        Pattern pattern = Pattern.compile(".*\"sessionToken\":\"(.*)\",.*");
        Matcher matcher = pattern.matcher(responseString);

        if (matcher.find()) {
            return matcher.group(1);
        }
        LOG.error("Unable to parse session token from response string {}", responseString);
        return null;
    }
}
