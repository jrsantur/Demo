package com.cajapiura.model.rest;

/**
 * Created by Junior on 16/12/2016.
 */

public class Authorizer {
    private String mApiClient;
    private String mApiSecret;

    public Authorizer(String apiClient, String apiSecret) {
        mApiClient = apiClient;
        mApiSecret = apiSecret;
    }

    public void setApiClient(String mApiClient) {
        this.mApiClient = mApiClient;
    }

    public void setApiSecret(String mApiSecret) {
        this.mApiSecret = mApiSecret;
    }

    public String getApiClient() {
        return mApiClient;
    }

    public String getApiSecret() {
        return mApiSecret;
    }
}
