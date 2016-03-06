package com.abbitt.trading.connection;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

abstract class OperationsBase {
    private static final Logger LOG = LogManager.getLogger(OperationsBase.class);
    private static final String HTTP_HEADER_X_APPLICATION = "X-Application";
    private static final String HTTP_HEADER_X_AUTHENTICATION = "X-Authentication";
    private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HTTP_HEADER_ACCEPT = "Accept";
    private static final String HTTP_HEADER_ACCEPT_CHARSET = "Accept-Charset";
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";
    private static final int CONNECTION_TIMEOUT = 2000;
    private static final int SOCKET_TIMEOUT = 2000;

    protected final Gson gson;
    private final String apiKey;
    private final String urlBase;
    private final String ssoToken;
    private final HttpClientBuilder clientBuilder;
    private final RequestConfig requestConfig;
    private final ResponseHandlerImpl responseHandler;

    protected OperationsBase(String apiKey, String urlBase, String ssoToken) {
        this.apiKey = apiKey;
        this.urlBase = urlBase;
        this.ssoToken = ssoToken;
        this.clientBuilder = HttpClientBuilder.create();
        this.requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT).build();
        this.responseHandler = new ResponseHandlerImpl();
        this.gson = new Gson();
    }

    protected String makeRequest(String url, Map<String, Object> params) {
        String jsonParams = paramsToJson(params);
        String postUrl = urlBase + url;
        LOG.debug("Making request to {} with params {}", postUrl, jsonParams);

        HttpPost post = new HttpPost(postUrl);
        String resp = null;
        try {
            post.setHeader(HTTP_HEADER_CONTENT_TYPE, CONTENT_TYPE);
            post.setHeader(HTTP_HEADER_ACCEPT, CONTENT_TYPE);
            post.setHeader(HTTP_HEADER_ACCEPT_CHARSET, ENCODING);
            post.setHeader(HTTP_HEADER_X_APPLICATION, apiKey);
            post.setHeader(HTTP_HEADER_X_AUTHENTICATION, ssoToken);
            post.setEntity(new StringEntity(jsonParams, ENCODING));

            CloseableHttpClient client = clientBuilder.setDefaultRequestConfig(requestConfig).build();
            resp = client.execute(post, responseHandler);
        } catch (IOException e) {
            LOG.error("Error executing API call for URL {} with params {}", url, jsonParams, e);
        }
        return resp;
    }

    private String paramsToJson(Map<String, Object> params) {
        return gson.toJson(params);
    }

    private static final class ResponseHandlerImpl implements ResponseHandler<String> {

        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            String responseString = entity == null ? null : EntityUtils.toString(entity, ENCODING);

            if (statusLine.getStatusCode() != 200) {
                LOG.error("API call failed, status code {}, response = {}", statusLine.getStatusCode(), responseString);
                return null;
            }

            return responseString;
        }
    }
}
