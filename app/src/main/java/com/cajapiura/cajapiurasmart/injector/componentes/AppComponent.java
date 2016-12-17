package com.cajapiura.cajapiurasmart.injector.componentes;

import com.cajapiura.cajapiurasmart.CajaMobileAplicacion;
import com.cajapiura.cajapiurasmart.injector.modulos.AppModule;
import com.cajapiura.model.repository.Repository;
import com.cajapiura.model.rest.Authorizer;
import com.cajapiura.model.rest.Endpoint;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Component;
import rx.Scheduler;

/**
 * Created by Junior on 14/12/2016.
 */
@Singleton
@Component(modules = AppModule.class)
public interface  AppComponent {
    CajaMobileAplicacion app();
    Repository repository();
    Endpoint restEndpoint();
    Authorizer authorizer();

    @Named("ui_thread")
    Scheduler uiThread();
    @Named("executor_thread") Scheduler executorThread();
}
