package com.cajapiura.cajapiurasmart.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.cajapiura.cajapiurasmart.Objetos.Cuenta;
import com.cajapiura.cajapiurasmart.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 23/11/2016.
 */

public class ListaCuentasAdapter extends RecyclerView.Adapter<ListaCuentasAdapter.ViewHolder > implements View.OnClickListener {

    Context context;
    ArrayList<Cuenta> data;
    private View.OnClickListener listener;
    private ArrayList<Cuenta> cuenta_ahorro_corriente;
    private ArrayList<Cuenta> cuenta_ahorro_plazo_fijo;
    private ArrayList<Cuenta> cuenta_cts;
    private ArrayList<Cuenta> cuenta_credito;
    int counter_servic = 0;
    ArrayList<ArrayList<Cuenta>> dataTotal;



    public ListaCuentasAdapter(){

    }

    public ListaCuentasAdapter(Context context , ArrayList<Cuenta> data){
        this.context = context;
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cuenta, parent, false);
        rootView.setOnClickListener(this);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



            for(int i=0 ; i<cuenta_ahorro_corriente.size(); i++){

                TableRow.LayoutParams layoutFila=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                TableRow.LayoutParams layoutTipoCuenta=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                TableRow.LayoutParams layoutCuenta=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

            }





        /*
        //TableRow.LayoutParams layoutResultado=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        boolean imprimio_cabecera = false;
        if(data.get(position).getServicio()=="210"){

             if(data.get(position).getServicio()=="210"){

                 if(imprimio_cabecera==false){
                    TableRow row = new TableRow(context);
                    row.setBackgroundColor(context.getResources().getColor(R.color.colorBotonIngresar));
                    row.setLayoutParams(layoutFila);
                    TextView tipo_cuenta  = new TextView(context);
                    tipo_cuenta.setText("Ahorro Corriente");
                    tipo_cuenta.setGravity(Gravity.LEFT);
                    tipo_cuenta.setPadding(4,4,4,4);
                    tipo_cuenta.setTextColor(Color.WHITE);
                    tipo_cuenta.setLayoutParams(layoutTipoCuenta);
                    holder.datos.addView(row);

                    Log.e("ListasCuentasAdapter" , "Se imprimio cabecera");
                 }
                 else {

                     TableRow row = new TableRow(context);
                     row.setBackgroundColor(context.getResources().getColor(R.color.colorBotonIngresar));
                     row.setLayoutParams(layoutFila);
                     row.setLayoutParams(layoutFila);
                     if(position%2==0){
                         row.setBackgroundColor(context.getResources().getColor(R.color.fondo_celda));
                     }
                     //cuenta
                     TextView cuenta = new TextView(context);
                     cuenta.setTextColor(Color.BLACK);
                     cuenta.setPadding(4,4,4,4);
                     cuenta.setLayoutParams(layoutTipoCuenta);
                     cuenta.setGravity(Gravity.LEFT);
                     cuenta.setText(data.get(position).getServicio().toString()+"-"+
                             data.get(position).getMoneda().toString()+"-"+
                             data.get(position).getCuenta());
                     row.removeAllViews();
                     row.addView(cuenta);
                     holder.datos.addView(row);
                     Log.e("ListasCuentasAdapter" , "Se imprimio cuerpo");
                 }

             }

        }
        */


    }

    @Override
    public int getItemCount() {
        return dataTotal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //TextView tipo_cuenta;
        //TextView numero_cuenta;
        //TextView disponible_cuenta;
        //TableLayout data_servic;
        CardView cardView;
        TableLayout datos;

        public ViewHolder(View itemView) {
            super(itemView);
            //tipo_cuenta = (TextView)itemView.findViewById(R.id.text_tipo_cuenta);
            //numero_cuenta = (TextView)itemView.findViewById(R.id.numero_cuenta);
            //disponible_cuenta = (TextView)itemView.findViewById(R.id.disponible_cuenta);
            //data_servic = (TableLayout)itemView.findViewById(R.id.data_servicio);
            //cardView = (CardView)itemView.findViewById(R.id.cardViewTable);
            datos  = (TableLayout)itemView.findViewById(R.id.data_servicio);


        }
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }


    public void agruparCuentasServic(ArrayList<Cuenta> data){
        this.data = data;
        cuenta_ahorro_corriente = new ArrayList<>();
        for(int i = 0; i<data.size(); i++){
            if(data.get(i).getServicio()=="210" ||  data.get(i).getServicio()=="110" ){
                cuenta_ahorro_corriente.add(data.get(i));
            }

            if(data.get(i).getServicio()=="310" ){
                cuenta_ahorro_plazo_fijo.add(data.get(i));
            }

            if(data.get(i).getServicio()=="430" ){
                cuenta_cts.add(data.get(i));
            }

            if(data.get(i).getServicio()=="80" ||  data.get(i).getServicio()=="96" ){
                cuenta_credito.add(data.get(i));
            }
        }
        dataTotal.add(cuenta_ahorro_corriente);
        dataTotal.add(cuenta_ahorro_plazo_fijo);
        dataTotal.add(cuenta_cts);
        dataTotal.add(cuenta_credito);
    }

    public void counterServic(){
        if(cuenta_ahorro_corriente.size() !=0 ){
            counter_servic++;
        }
        if(cuenta_ahorro_plazo_fijo.size()!=0){
            counter_servic++;
        }
        if(cuenta_cts.size()!=0){
            counter_servic++;
        }
        if (cuenta_credito.size()!=0){
            counter_servic++;
        }
    }

}
