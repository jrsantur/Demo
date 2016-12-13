package com.cajapiura.model.webservice;

/**
 * Created by Junior on 13/12/2016.
 */

public class WebServiceAutorize {
    private String mApiClient;
    private String mApiSecret;

    public WebServiceAutorize(String apiClient, String apiSecret) {
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
