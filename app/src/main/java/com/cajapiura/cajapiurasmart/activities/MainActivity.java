package com.cajapiura.cajapiurasmart.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.cajapiura.cajapiurasmart.Objetos.Cuenta;
import com.cajapiura.cajapiurasmart.R;
import com.cajapiura.cajapiurasmart.adapters.ListaCuentasAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Cuenta> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.listas_cuentas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        ListaCuentasAdapter adapter;
        data = new ArrayList<>();


        //data

        data = new ArrayList<>();

        Cuenta cuenta1 = new Cuenta();
        cuenta1.setServicio("210");
        cuenta1.setMoneda("02");
        cuenta1.setCuenta("1111111");
        cuenta1.setMonto(125.36);
        data.add(cuenta1);


        Cuenta cuenta2 = new Cuenta();
        cuenta2.setServicio("210");
        cuenta2.setMoneda("01");
        cuenta2.setCuenta("2222222");
        cuenta2.setMonto(125.36);
        data.add(cuenta2);



        Cuenta cuenta3 = new Cuenta();
        cuenta3.setServicio("210");
        cuenta3.setMoneda("02");
        cuenta3.setCuenta("3333333");
        cuenta3.setMonto(125.36);
        data.add(cuenta3);


        Cuenta cuenta4 = new Cuenta();
        cuenta4.setServicio("210");
        cuenta4.setMoneda("02");
        cuenta4.setCuenta("44444444");
        cuenta4.setMonto(125.36);
        data.add(cuenta4);




        adapter = new ListaCuentasAdapter(getApplicationContext(),data);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Pulsado el elemento " + mRecyclerView.getChildPosition(v));
                Intent i = new Intent(MainActivity.this, DetalleCuentaActivity.class);
                startActivity(i);
            }
        });

        mRecyclerView.setAdapter(adapter);


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0)
                    // Puedes ocultarlo simplemente
                    //fab.hide();
                    // o añadir la animación deseada
                    fab.animate().translationY(fab.getHeight() +
                            getResources().getDimension(R.dimen.fab_margin))
                            .setInterpolator(new LinearInterpolator())
                            .setDuration(1000); // Cambiar al tiempo deseado
                else if (dy < 0)
                    //fab.show();
                    fab.animate().translationY(0)
                            .setInterpolator(new LinearInterpolator())
                            .setDuration(1000); // Cambiar al tiempo deseado

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , MapsActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed (){

        if (false) {
            finish();
            super.onBackPressed();
        } else {

        }
    }


}
