package com.cajapiura.model.entidades;

import java.util.List;

/**
 * Created by Junior on 14/12/2016.
 */

public class WrapperClienteCuenta {

    Cliente cliente;
    List<CuentaAhorroCorriente> cueaho;
    List<CuentaPlazoFijo> cueplj;
    List<CuentaCTS> cuects;
    List<CuentaCredito> cuecre;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CuentaAhorroCorriente> getCueaho() {
        return cueaho;
    }

    public void setCueaho(List<CuentaAhorroCorriente> cueaho) {
        this.cueaho = cueaho;
    }

    public List<CuentaPlazoFijo> getCueplj() {
        return cueplj;
    }

    public void setCueplj(List<CuentaPlazoFijo> cueplj) {
        this.cueplj = cueplj;
    }

    public List<CuentaCTS> getCuects() {
        return cuects;
    }

    public void setCuects(List<CuentaCTS> cuects) {
        this.cuects = cuects;
    }

    public List<CuentaCredito> getCuecre() {
        return cuecre;
    }

    public void setCuecre(List<CuentaCredito> cuecre) {
        this.cuecre = cuecre;
    }
}
