package com.cajapiura.model.rest;

import com.cajapiura.model.entity.TramaEntity;
import com.cajapiura.model.repository.Repository;
import com.cajapiura.model.rest.util.deserializer.ResultDeserializer;
import com.cajapiura.model.rest.util.interceptors.SigningIterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.List;

import javax.inject.Inject;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Junior on 16/12/2016.
 */

public class RestDataSource implements Repository {

    public static String END_POINT       = "http://gateway.marvel.com/";
    public static String PARAM_API_KEY   = "apikey";
    public static String PARAM_HASH      = "hash";
    public static String PARAM_TIMESTAMP = "ts";

    private final CajaMobileApi cajaMobileApi;
    public final static int MAX_ATTEMPS = 3;

    @Inject
    RestDataSource(Authorizer authorizer){
        OkHttpClient client = new OkHttpClient();

        SigningIterceptor signingIterceptor = new SigningIterceptor(authorizer.getApiClient() , authorizer.getApiSecret());
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        client.interceptors().add(signingIterceptor);
        client.interceptors().add(loggingInterceptor);

        Gson customGsonInstance = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<TramaEntity>>(){}.getType(),
                        new ResultDeserializer<TramaEntity>())
                .create();

        Retrofit adapter = new Retrofit.Builder().baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create(customGsonInstance))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        cajaMobileApi = adapter.create(CajaMobileApi.class);

    }


    @Override
    public Observable<TramaEntity> getTrama(final String trama) {
        return cajaMobileApi.getTramaResult(trama).flatMap(new Func1<List<TramaEntity>, Observable<TramaEntity>>() {
            @Override
            public Observable<TramaEntity> call(List<TramaEntity> tramaEntities) {
                return Observable.just(tramaEntities.get(0));
            }
        });
    }
}
