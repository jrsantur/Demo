package com.cajapiura.cajapiurasmart.Objetos;

/**
 * Created by Junior on 28/11/2016.
 */

public class CuentaServico {

    String tipo_cuenta;
    Cuenta cuenta;

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
