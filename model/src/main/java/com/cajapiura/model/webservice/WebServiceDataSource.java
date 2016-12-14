package com.cajapiura.model.webservice;

import com.cajapiura.model.repositorio.Repository;

import rx.Observable;

/**
 * Created by Junior on 13/12/2016.
 */

public class WebServiceDataSource implements Repository{

    public static String END_POINT       = "urlwebservices";
    public static String PARAM_API_KEY   = "apikey";
    public static String PARAM_HASH      = "hash";
    public static String PARAM_TIMESTAMP = "ts";


    @Override
    public Observable<String> getTrama(String trama) {
        return null;
    }
}
