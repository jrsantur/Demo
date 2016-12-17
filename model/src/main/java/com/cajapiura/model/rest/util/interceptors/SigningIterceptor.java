package com.cajapiura.model.rest.util.interceptors;

import com.cajapiura.model.rest.RestDataSource;
import com.cajapiura.model.rest.util.ApiUtils;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Junior on 16/12/2016.
 */

public class SigningIterceptor implements Interceptor {
    private final String mApiKey;
    private final String mApiSecret;

    public SigningIterceptor(String apiKey, String apiSecret) {
        mApiKey = apiKey;
        mApiSecret = apiSecret;
    }

    @Override public Response intercept(Chain chain) throws IOException {
        String marvelHash = ApiUtils.generateMarvelHash(mApiKey, mApiSecret);
        Request oldRequest = chain.request();

        HttpUrl.Builder authorizedUrlBuilder = oldRequest.httpUrl().newBuilder()
                .scheme(oldRequest.httpUrl().scheme())
                .host(oldRequest.httpUrl().host());

        authorizedUrlBuilder.addQueryParameter(RestDataSource.PARAM_API_KEY, mApiKey)
                .addQueryParameter(RestDataSource.PARAM_TIMESTAMP, ApiUtils.getUnixTimeStamp())
                .addQueryParameter(RestDataSource.PARAM_HASH, marvelHash);

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}

