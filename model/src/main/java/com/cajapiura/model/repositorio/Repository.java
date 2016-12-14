package com.cajapiura.model.repositorio;

/**
 * Created by Junior on 12/12/2016.
 */

import com.cajapiura.model.entidades.Cliente;
import com.cajapiura.model.entidades.CuentaAhorroCorriente;
import com.cajapiura.model.entidades.CuentaCTS;
import com.cajapiura.model.entidades.CuentaCredito;
import com.cajapiura.model.entidades.CuentaPlazoFijo;

import java.util.List;
import rx.Observable;

public interface Repository {
    Observable<String> getTrama(String trama);
}
