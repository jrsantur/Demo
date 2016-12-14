package com.cajapiura.model.webservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Junior on 14/12/2016.
 */

@Root(name = "Table", strict = false)
public class TablaElementos {

    @Element(name = "tramaResponse" , required = false)
    String trama;

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }
}
