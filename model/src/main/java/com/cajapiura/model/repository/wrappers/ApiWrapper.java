package com.cajapiura.model.repository.wrappers;

/**
 * Created by Junior on 16/12/2016.
 */

public class ApiWrapper {

    private String code;
    private String status;

    private TramaDataWrapper data;

    public String getCode() {

        return code;
    }

    public String getStatus() {

        return status;
    }

    public TramaDataWrapper getData() {
        return data;
    }
}
