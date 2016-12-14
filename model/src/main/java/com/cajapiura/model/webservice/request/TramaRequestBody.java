package com.cajapiura.model.webservice.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;



/**
 * Created by Junior on 13/12/2016.
 */

@Root(name = "soap12:Body", strict = false)
public class TramaRequestBody {

      //cambiar por el metodo correspontiente
    @Element( name = "getTrama" , required = false)
    private TramaRequestData tramaRequestData;

    public TramaRequestData getTramaRequestData() {
        return tramaRequestData;
    }

    public void setTramaRequestData(TramaRequestData tramaRequestData) {
        this.tramaRequestData = tramaRequestData;
    }




}
