package com.cajapiura.cajapiurasmart.views.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.cajapiura.cajapiurasmart.CajaMobileAplicacion;
import com.cajapiura.cajapiurasmart.R;
import com.cajapiura.cajapiurasmart.injector.componentes.DaggerCajaMobileComponent;
import com.cajapiura.cajapiurasmart.injector.modulos.ActivityModule;
import com.cajapiura.cajapiurasmart.mvp.presenters.AutenticationPresenter;
import com.cajapiura.cajapiurasmart.views.fragments.AutenticacionFragment;
import com.cajapiura.cajapiurasmart.views.fragments.TarjetaCoordenadasFragment;

import javax.inject.Inject;


public class AutenticacionActivity extends AppCompatActivity implements AutenticacionFragment.onAutenticacionButtonPress{


    FragmentTransaction transaction;
    AutenticacionFragment fragmentAut;
    Integer number_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacion);
        //views
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        initializeDependencyInjector();

        fragmentAut = new AutenticacionFragment().newInstance();
        transaction = getSupportFragmentManager().beginTransaction().add(R.id.autentication_content , fragmentAut);
        transaction.commit();

    }

    @Override
    public void onBackPressed (){

        if (number_fragment==1) {
            finish();
            super.onBackPressed();
        } else {

        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void ingresar(boolean valor) {

        TarjetaCoordenadasFragment fragment = new TarjetaCoordenadasFragment().newInstance();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.autentication_content , fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        number_fragment = 2;

    }

    private void initializeDependencyInjector() {
        CajaMobileAplicacion cajaMobilApplication = (CajaMobileAplicacion) getApplication();


        DaggerCajaMobileComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(cajaMobilApplication.getAppComponent())
                .build().inject(this);
    }





}
