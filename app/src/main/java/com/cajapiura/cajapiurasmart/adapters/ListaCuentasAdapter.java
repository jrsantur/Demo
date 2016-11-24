package com.cajapiura.cajapiurasmart.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        TextView tipo_cuenta = new TextView(context);
        TextView cuenta = new TextView(context);
        TextView disponible = new TextView(context);
        int cabecera = 0;
        TableRow row  ;


         //   if (data.get(position).getServicio()=="210" || data.get(position).getServicio()=="110" ){


                if(position ==0){

                    row= new TableRow(context);
                    row.setId(100+position);
                    row.setLayoutParams(new TableRow.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));

                    Log.e("cabecera", "Se escribio cabecera");
                    tipo_cuenta.setText("Ahorro Corriente");
                    tipo_cuenta.setTextSize(18);
                    tipo_cuenta.setTextColor(Color.WHITE);
                    row.addView(tipo_cuenta);
                    row.setPadding(4,4,4,4);
                    row.setBackgroundColor(context.getResources().getColor(R.color.colorBotonIngresar));
                    Log.e("cabecer", ""+position);
                }

                else {

                    row= new TableRow(context);
                    row.setId(100+position);
                    row.setLayoutParams(new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    Log.e("cabecera", "Se escribio cuerpo");

                    cuenta.setId(100+position);
                    cuenta.setText("80-01-111111");
                    cuenta.setTextColor(Color.BLACK);
                    cuenta.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    row.addView(cuenta);

                    disponible.setId(200+position);
                    disponible.setText("1000.00");
                    disponible.setTextColor(Color.BLACK);
                    disponible.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    row.addView(disponible);
                }

                holder.data_servic.addView(row, new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TableLayout data_servic;

        public ViewHolder(View itemView) {
            super(itemView);
            //tipo_cuenta = (TextView)itemView.findViewById(R.id.text_tipo_cuenta);
            //numero_cuenta = (TextView)itemView.findViewById(R.id.numero_cuenta);
            //disponilbe_cuenta = (TextView)itemView.findViewById(R.id.disponible_cuenta);
            data_servic = (TableLayout)itemView.findViewById(R.id.data_servicio);

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

}
