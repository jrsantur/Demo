package com.cajapiura.model.webservice.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;

/**
 * Created by Junior on 14/12/2016.
 */

@Root(name = "GetTramaResult",strict = false)
public class TramaResponseInfo {

    @ElementList(name = "NewDataSet",required = false)
    List<TablaElementos> elements;

    public List<TablaElementos> getElements() {
        return elements;
    }

    public void setElements(List<TablaElementos> elements) {
        this.elements = elements;
    }
}
