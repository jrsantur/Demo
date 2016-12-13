package com.cajapiura.model.webservice;

/**
 * Created by Junior on 13/12/2016.
 */

import com.cajapiura.model.entidades.Cliente;

import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface CajaMobileApi {

    //link de la web servis del metodo
    @GET("/cliente")                        //metodo que ejecuta la consulta
    Observable<Cliente> getCharacters (@Query("trama") String  trama);


}
