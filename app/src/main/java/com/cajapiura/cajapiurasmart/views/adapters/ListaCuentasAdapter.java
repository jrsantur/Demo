package com.cajapiura.cajapiurasmart.views.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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

import com.cajapiura.cajapiurasmart.Objetos.Cuenta;
import com.cajapiura.cajapiurasmart.Objetos.CuentaServico;
import com.cajapiura.cajapiurasmart.R;

import java.util.ArrayList;

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
    ArrayList<ArrayList<Cuenta> > dataTotal;
    ArrayList<CuentaServico> datos;


    public ListaCuentasAdapter(){

    }

    public ListaCuentasAdapter(Context context , ArrayList<Cuenta> data){
        this.context = context;
        this.data = data;
        dataTotal = new ArrayList<>();
        agruparCuentasServic(data);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cuenta, parent, false);
        rootView.setOnClickListener(this);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutTipoCuenta = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutCuenta = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams layoutDisponible =new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 2.0f);

        if(cuenta_ahorro_corriente.size()!=0 || cuenta_cts.size()!=0 || cuenta_ahorro_plazo_fijo.size()!=0 | cuenta_credito.size()!=0){

            int tamaño = dataTotal.get(position).size();
            TableRow row = new TableRow(context);
            for(int i=0 ; i<tamaño+1; i++){
                if(i==0){
                    //cabecera
                    row.setBackgroundColor(context.getResources().getColor(R.color.colorBotonIngresar));
                    row.setLayoutParams(layoutFila);
                    TextView tipo_cuenta  = new TextView(context);
                    tipo_cuenta.setText(dataTotal.get(position).get(i).getTipo_cuenta().toString());
                    tipo_cuenta.setGravity(Gravity.LEFT);
                    tipo_cuenta.setPadding(8,8,8,8);
                    tipo_cuenta.setTextSize(19);
                    tipo_cuenta.getTextSize();
                    tipo_cuenta.setTextColor(Color.WHITE);
                    tipo_cuenta.setTypeface(null, Typeface.BOLD);
                    tipo_cuenta.setLayoutParams(layoutTipoCuenta);
                    row.addView(tipo_cuenta);
                    row.setClickable(false);
                    holder.datos.addView(row);
                }else{
                    row = new TableRow(context);
                    row.setLayoutParams(layoutFila);
                    if(i%2==0 && i!=0){
                        row.setBackgroundColor(context.getResources().getColor(R.color.fondo_celda));
                    }
                    //cuenta
                    TextView cuenta = new TextView(context);
                    cuenta.setTextColor(Color.BLACK);
                    cuenta.setPadding(16,16,16,16);
                    cuenta.setLayoutParams(layoutCuenta);
                    cuenta.setGravity(Gravity.LEFT);
                    cuenta.setTextSize(17);
                    cuenta.setText(
                            dataTotal.get(position).get(i-1).getServicio()+" - "+
                                    dataTotal.get(position).get(i-1).getMoneda()+" - "+
                                    dataTotal.get(position).get(i-1).getCuenta()
                    );

                    //saldo disponible
                    TextView disponible = new TextView(context);
                    disponible.setLayoutParams(layoutDisponible);
                    disponible.setTextColor(Color.BLACK);
                    disponible.setPadding(16,16,16,16);
                    disponible.setTextSize(19);
                    disponible.setGravity(Gravity.RIGHT);
                    String denominacion_moneda = "";
                    if ( dataTotal.get(position).get(i-1).getMoneda()=="01")
                        denominacion_moneda = "S/. ";
                    else
                        denominacion_moneda = "$ ";
                    disponible.setText(denominacion_moneda+ dataTotal.get(position).get(i-1).getMonto());
                    disponible.setTypeface(Typeface.DEFAULT_BOLD);
                    disponible.setPadding(16,16,24,16);

                    //agregando views
                    row.removeAllViews();
                    row.addView(cuenta);
                    row.addView(disponible);
                    row.setClickable(true);
                    holder.datos.addView(row);

                    row.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });

                    Log.e("ListasCuentasAdapter" , "Se imprimio cuerpo");
                }

            }

        }

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
        cuenta_ahorro_plazo_fijo = new ArrayList<>();
        cuenta_cts = new ArrayList<>();
        cuenta_credito = new ArrayList<>();
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

}
