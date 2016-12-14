package com.cajapiura.model.webservice.response;

import org.simpleframework.xml.Element;

/**
 * Created by Junior on 14/12/2016.
 */

public class TramaResponseBody {

    @Element(name = "GetTramaResponse", required = false)
    private TramaResponseData tramaResponseData;

    public TramaResponseData getData(){
        return tramaResponseData;
    }
    public void setData(TramaResponseData tramaResponseData){
        this.tramaResponseData = tramaResponseData;
    }
}
