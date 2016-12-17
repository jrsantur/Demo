package com.cajapiura.cajapiurasmart.injector.componentes;

import com.cajapiura.cajapiurasmart.injector.Activity;
import com.cajapiura.cajapiurasmart.injector.modulos.ActivityModule;
import com.cajapiura.cajapiurasmart.injector.modulos.InformationModule;
import com.cajapiura.cajapiurasmart.views.activities.AutenticacionActivity;
import com.cajapiura.cajapiurasmart.views.activities.DetalleCuentaActivity;
import com.cajapiura.cajapiurasmart.views.activities.MainActivity;
import com.cajapiura.domain.GetTramaUsecase;

import dagger.Component;


@Activity
@Component(dependencies = AppComponent.class, modules = {InformationModule.class , ActivityModule.class })
public interface InformationComponent {
    void inject (MainActivity activity);

    GetTramaUsecase getTramaUsecase();

}
