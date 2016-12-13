package com.cajapiura.model.webservice.util.interceptors;

/**
 * Created by Junior on 13/12/2016.
 */

import com.cajapiura.model.webservice.WebServiceDataSource;
import com.cajapiura.model.webservice.util.WebServisApiUtil;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class WSSigningIterceptor implements Interceptor {
    private final String mApiKey;
    private final String mApiSecret;

    public  WSSigningIterceptor(String apiKey, String apiSecret) {
        mApiKey = apiKey;
        mApiSecret = apiSecret;
    }

    @Override public Response intercept(Chain chain) throws IOException {
        String marvelHash = WebServisApiUtil.generateMarvelHash(mApiKey, mApiSecret);
        Request oldRequest = chain.request();

        HttpUrl.Builder authorizedUrlBuilder = oldRequest.httpUrl().newBuilder()
                .scheme(oldRequest.httpUrl().scheme())
                .host(oldRequest.httpUrl().host());

        authorizedUrlBuilder.addQueryParameter(WebServiceDataSource.PARAM_API_KEY, mApiKey)
                .addQueryParameter(WebServiceDataSource.PARAM_TIMESTAMP, WebServisApiUtil.getUnixTimeStamp())
                .addQueryParameter(WebServiceDataSource.PARAM_HASH, marvelHash);

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
