package com.cajapiura.model.webservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Junior on 14/12/2016.
 */

@Root(name = "GetTramaResponse", strict = false)
//@Namespace(reference = "http://www.webserviceX.NET")
public class TramaResponseData {

    @Element(name = "GetTramaResult", required = false)
    private TramaResponseInfo data;

    public TramaResponseInfo getData() {
        return data;
    }

    public void setData(TramaResponseInfo data) {
        this.data = data;
    }

}


