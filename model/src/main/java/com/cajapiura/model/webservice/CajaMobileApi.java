package com.cajapiura.model.webservice;

/**
 * Created by Junior on 13/12/2016.
 */

import com.cajapiura.model.entidades.Cliente;
import com.cajapiura.model.webservice.response.TramaResponseBody;
import com.cajapiura.model.webservice.response.TramaResponseEnvelope;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface CajaMobileApi {

    //link de la web servis del metodo
    @POST("/provcioanl")                        //metodo que ejecuta la consulta
    Observable<TramaResponseEnvelope> requesTramaInfo (@Body TramaResponseBody body);

}
