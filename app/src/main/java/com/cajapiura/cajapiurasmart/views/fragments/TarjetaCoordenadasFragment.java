package com.cajapiura.cajapiurasmart.views.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.cajapiura.cajapiurasmart.R;
import com.cajapiura.cajapiurasmart.views.activities.MainActivity;
import java.util.Random;


public class TarjetaCoordenadasFragment extends Fragment {


    public TarjetaCoordenadasFragment() {

    }


    public static TarjetaCoordenadasFragment newInstance() {
        TarjetaCoordenadasFragment fragment = new TarjetaCoordenadasFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tarjeta_coordenadas, container, false);

        TextView coordenada = (TextView)rootView.findViewById(R.id.text_coordenada) ;
        coordenada.setText(getletra()+getNumero());

        Button ingresar = (Button) rootView.findViewById(R.id.btn_ingresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        return rootView;
    }

    public String getletra(){
        Resources res = getResources();
        String letras [] = res.getStringArray(R.array.columna_coordenada);
        Random rm = new Random();
        int numAleatorio = rm.nextInt(7);
        return letras[numAleatorio];

    }

    public String getNumero(){
        Resources res = getResources();
        String numeros  [] =  res.getStringArray(R.array.fila_coordenada);
        Random rm = new Random();
        int numAleatorio = rm.nextInt(7);
        return numeros[numAleatorio];
    }









}
