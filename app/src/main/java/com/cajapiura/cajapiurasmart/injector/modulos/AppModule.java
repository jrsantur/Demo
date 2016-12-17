package com.cajapiura.cajapiurasmart.injector.modulos;

import com.cajapiura.cajapiurasmart.BuildConfig;
import com.cajapiura.cajapiurasmart.CajaMobileAplicacion;
import com.cajapiura.model.repository.Repository;
import com.cajapiura.model.rest.Authorizer;
import com.cajapiura.model.rest.Endpoint;
import com.cajapiura.model.rest.RestDataSource;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Junior on 14/12/2016.
 */
@Module
public class AppModule {
    private final CajaMobileAplicacion app;

    public AppModule(CajaMobileAplicacion cajaMobileAplicacion){
        this.app = cajaMobileAplicacion;
    }

    @Provides @Singleton
    CajaMobileAplicacion providerCajaMobileAplicacionContext(){
        return app;
    }
    @Provides
    Authorizer provideAuthorizer() {
        return new Authorizer(BuildConfig.CMACMOBILE_PUBLIC_KEY, BuildConfig.CMACMOBILE_PRIVATE_KEY);
    }
    @Provides
    Endpoint providerRestEndpoin(){
        return new Endpoint("http://gateway.marvel.com/");
    }
    @Provides @Singleton
    Repository provideDataRepository(RestDataSource restDataSource) {
        return restDataSource;
    }
    @Provides @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.newThread();
    }

    @Provides @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
