package com.cajapiura.model.webservice.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Junior on 13/12/2016.
 */
@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class TramaRequestEnvelope {

    @Element(name = "soap12:Body", required = false)
    private TramaRequestBody body;

    public TramaRequestBody getBody() {
        return body;
    }

    public void setBody( TramaRequestBody body) {
        this.body = body;
    }
}
