package com.cajapiura.model.webservice.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Junior on 13/12/2016.
 */

@Root(name = "GetInfoByState", strict = false)
//@Namespace(reference = "http://www.webserviceX.NET")
public class TramaRequestData {

    @Element(name = "tramaRequest", required = false)
    private String trama;

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }
}
