package com.cajapiura.cajapiurasmart.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cajapiura.cajapiurasmart.R;
import com.cajapiura.cajapiurasmart.fragments.AutenticacionFragment;
import com.cajapiura.cajapiurasmart.fragments.TarjetaCoordenadasFragment;

public class AutenticacionActivity extends AppCompatActivity implements AutenticacionFragment.onAutenticacionButtonPress{


    FragmentTransaction transaction;
    AutenticacionFragment fragmentAut;
    Integer number_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacion);
        //view

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
}
