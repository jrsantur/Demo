package com.cajapiura.model.webservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Junior on 14/12/2016.
 */
@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class TramaResponseEnvelope {

    @Element(required = false, name = "Body")
    private TramaResponseBody body;

    public TramaResponseBody getBody() {
        return body;
    }

    public void setBody(TramaResponseBody body) {
        this.body = body;
    }
}
