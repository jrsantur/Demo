package com.cajapiura.cajapiurasmart.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
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
        TableLayout data_servic ;
        String servic = "80";

                if(servic == "80"){

                    data_servic = new TableLayout(context);
                    data_servic.setLayoutParams( new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

                    if(position ==0){

                        TableRow row = new TableRow(context);
                        row.setLayoutParams(new TableRow.LayoutParams(
                                TableRow.LayoutParams.MATCH_PARENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        row.setId(100+position);
                        Log.e("cabecera", "Se escribio cabecera");
                        tipo_cuenta.setText("Ahorro Corriente");
                        tipo_cuenta.setTextSize(18);
                        tipo_cuenta.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        tipo_cuenta.setTextColor(Color.WHITE);
                        row.setPadding(4,4,4,4);
                        row.setBackgroundColor(context.getResources().getColor(R.color.colorBotonIngresar));
                        row.addView(tipo_cuenta, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        Log.e("cabecer", ""+position);

                        data_servic.addView(row, new TableLayout.LayoutParams(
                                TableLayout.LayoutParams.MATCH_PARENT,
                                TableLayout.LayoutParams.WRAP_CONTENT));

                    }
                    else {

                        Log.e("cabecera", "Se escribio cuerpo");
                        TableRow row = new TableRow(context);
                        row.setLayoutParams(new TableRow.LayoutParams(
                                TableRow.LayoutParams.MATCH_PARENT,
                                TableRow.LayoutParams.WRAP_CONTENT));
                        row.setId(100+position);
                        cuenta.setId(100+position);
                        cuenta.setText("80-01-111111");
                        cuenta.setTextColor(Color.BLACK);
                        cuenta.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        row.addView(cuenta,  new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        disponible.setId(200+position);
                        disponible.setText("1000.00");
                        disponible.setTextColor(Color.BLACK);
                        disponible.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        row.addView(disponible , new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        data_servic.addView(row, new TableLayout.LayoutParams(
                                TableLayout.LayoutParams.MATCH_PARENT,
                                TableLayout.LayoutParams.WRAP_CONTENT));

                    }

                    holder.cardView.addView(data_servic);
                }




    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //TextView tipo_cuenta;
        //TextView numero_cuenta;
        //TextView disponible_cuenta;
        //TableLayout data_servic;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            //tipo_cuenta = (TextView)itemView.findViewById(R.id.text_tipo_cuenta);
            //numero_cuenta = (TextView)itemView.findViewById(R.id.numero_cuenta);
            //disponible_cuenta = (TextView)itemView.findViewById(R.id.disponible_cuenta);
            //data_servic = (TableLayout)itemView.findViewById(R.id.data_servicio);
            cardView = (CardView)itemView.findViewById(R.id.cardViewTable);


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
