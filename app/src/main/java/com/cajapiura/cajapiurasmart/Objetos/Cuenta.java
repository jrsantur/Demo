package com.cajapiura.cajapiurasmart.Objetos;

/**
 * Created by Junior on 23/11/2016.
 */

public class Cuenta {


    String tipo_cuenta;
    String descripcion_cuenta;
    String servicio;
    String moneda;
    String cuenta;
    Double monto;

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public String getDescripcion_cuenta() {
        return descripcion_cuenta;
    }

    public void setDescripcion_cuenta(String descripcion_cuenta) {
        this.descripcion_cuenta = descripcion_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
