package com.cajapiura.cajapiurasmart.injector.componentes;

import com.cajapiura.cajapiurasmart.CajaMobileAplicacion;
import com.cajapiura.cajapiurasmart.injector.modulos.AppModule;
import com.cajapiura.model.webservice.Endpoint;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Junior on 14/12/2016.
 */
@Singleton
@Component(modules = AppModule.class)
public interface  AppComponent {
    CajaMobileAplicacion app();


    Endpoint restEndpoint();
}
