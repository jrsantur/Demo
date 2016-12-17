package com.cajapiura.model.rest;

import com.cajapiura.model.entity.TramaEntity;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Junior on 16/12/2016.
 */

public interface CajaMobileApi {

    @GET("/v1/public/trama")
    Observable<List<TramaEntity>> getTramaResult (@Query("trama") String trama);
}
