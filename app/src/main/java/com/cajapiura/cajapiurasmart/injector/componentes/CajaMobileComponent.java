package com.cajapiura.cajapiurasmart.injector.componentes;

import android.content.Context;

import com.cajapiura.cajapiurasmart.views.activities.MainActivity;
import com.cajapiura.cajapiurasmart.injector.Activity;
import com.cajapiura.cajapiurasmart.injector.modulos.ActivityModule;

import dagger.Component;

/**
 * Created by Junior on 14/12/2016.
 */

@Activity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface CajaMobileComponent extends ActivityComponent {

    public interface AvengersComponent extends ActivityComponent {
        void inject (MainActivity activity);
        Context activityContext();
    }

}
