package com.cajapiura.cajapiurasmart.coneccion;

import com.solab.iso8583.IsoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import pe.com.cajapiura.setfilink.data.ClienteSETFI;

/**
 * Created by Junior on 29/11/2016.
 */

public class Cliente9999 implements Runnable {

    Logger log = LoggerFactory.getLogger(Cliente9999.class);
    private IsoMessage trama;
    public Cliente9999(){

    }


    @Override
    public void run() {

        int cont = 0;
        String tramaRpta = null;
        ClienteSETFI clienteSETFI = new ClienteSETFI();


    }

}
