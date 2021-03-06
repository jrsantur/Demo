package com.cajapiura.cajapiurasmart.views.fragments;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


import com.cajapiura.cajapiurasmart.mvp.presenters.AutenticationPresenter;
import com.cajapiura.cajapiurasmart.mvp.views.AutenticacionView;
import com.cajapiura.cajapiurasmart.views.adapters.CustomSpinnerAdapter;
import com.cajapiura.cajapiurasmart.R;
import com.cajapiura.model.entity.TramaEntity;

import java.util.ArrayList;

import javax.inject.Inject;


public class AutenticacionFragment extends Fragment  implements AutenticacionView{

    onAutenticacionButtonPress mCallback;
    private static final String ARG_PARAM1 = "param1";
    public static boolean ingreso ;
    AppCompatSpinner spinner;
    Button ingresar;
    ProgressBar progressBar;
    View rootVoew;
    @Inject
    AutenticationPresenter autenticationPresenter;

    @Inject
    AutenticationPresenter mAutenticationPresenter;



    @Override
    public void bindCharacterList(TramaEntity trama) {

    }

    @Override
    public void showLoadingView() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showEmptyIndicator() {

    }

    @Override
    public void hideEmptyIndicator() {

    }

    @Override
    public void showConnectionErrorMessage() {

    }

    @Override
    public void showLightError() {

    }

    @Override
    public void hideErrorView() {

    }

    @Override
    public void showUknownErrorMessage() {

    }

    @Override
    public void showFragmentCoordenadas() {

    }

    @Override
    public void showCuentasScreen(String trama) {

    }

    @Override
    public void sendTrama(String trama) {

    }





    public  interface onAutenticacionButtonPress{
        void ingresar(boolean valor);
    }


    public AutenticacionFragment() {
        // Required empty public constructor
    }

    public static AutenticacionFragment newInstance() {
        AutenticacionFragment fragment = new AutenticacionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ingreso = getArguments().getBoolean(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootVoew = inflater.inflate(R.layout.content_autenticacion, container, false);
        spinner = (AppCompatSpinner)rootVoew.findViewById(R.id.list_tarjetas);
        progressBar  = (ProgressBar)rootVoew.findViewById(R.id.progressBar);
        ingresar = (Button) rootVoew.findViewById(R.id.btnIngresar);

        initializePresenter();
        populateSpinnerTarjetas();
        //aqui es donde se procedera a la autenticacion con el web servis
        ingreso = true;
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ingreso = true){
                    mCallback.ingresar(ingreso);
                }
            }
        });

        return rootVoew;
    }


    @Override
    public void onResume() {
        super.onResume();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i;
                if(position == 0){
                    EditText numeroTarjeta = (EditText) rootVoew.findViewById(R.id.numero_tarjeta);
                    numeroTarjeta.setText("81030000");
                    numeroTarjeta.setSelection(8);
                }

                if(position == 1){
                    EditText numeroTarjeta = (EditText) rootVoew.findViewById(R.id.numero_tarjeta);
                    numeroTarjeta.setText("45733900");
                    numeroTarjeta.setSelection(8);
                }

                if(position == 2){
                    EditText numeroTarjeta = (EditText) rootVoew.findViewById(R.id.numero_tarjeta);
                    numeroTarjeta.setText("45757100");
                    numeroTarjeta.setSelection(8);
                }

                if(position == 3){
                    EditText numeroTarjeta = (EditText) rootVoew.findViewById(R.id.numero_tarjeta);
                    numeroTarjeta.setText("45589500");
                    numeroTarjeta.setSelection(8);
                }

                if(position == 4){
                    EditText numeroTarjeta = (EditText) rootVoew.findViewById(R.id.numero_tarjeta);
                    numeroTarjeta.setText("45589600");
                    numeroTarjeta.setSelection(8);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public  void populateSpinnerTarjetas(){
        Resources rs = getResources();
        String nombre_tarjetas [] = rs.getStringArray(R.array.nombre_tarjetas);
        ArrayList<String> list_nombres_tarjetas = new ArrayList<>();
        for (int i = 0; i<nombre_tarjetas.length; i++){
            list_nombres_tarjetas.add(nombre_tarjetas[i]);
        }

        CustomSpinnerAdapter customSpinnerAdapter=new CustomSpinnerAdapter(getActivity().getApplicationContext(),list_nombres_tarjetas);
        //ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( getActivity().getApplicationContext(), R.array.nombre_tarjetas , android.R.layout.simple_spinner_item);
        //spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(customSpinnerAdapter);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (onAutenticacionButtonPress) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    private void initializePresenter() {
        autenticationPresenter.attachView(this);
        autenticationPresenter.onCreate();
    }

}
