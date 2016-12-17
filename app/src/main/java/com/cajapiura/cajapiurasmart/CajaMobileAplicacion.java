package com.cajapiura.cajapiurasmart;

import android.app.Application;

import com.cajapiura.cajapiurasmart.injector.componentes.AppComponent;

import com.cajapiura.cajapiurasmart.injector.componentes.DaggerAppComponent;
import com.cajapiura.cajapiurasmart.injector.modulos.AppModule;

/**
 * Created by Junior on 14/12/2016.
 */

public class CajaMobileAplicacion extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
