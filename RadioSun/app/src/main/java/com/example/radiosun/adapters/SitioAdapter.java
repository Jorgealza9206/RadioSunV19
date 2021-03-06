package com.example.radiosun.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radiosun.R;
import com.example.radiosun.modelos.Sitio;

import java.util.ArrayList;

public class SitioAdapter extends RecyclerView.Adapter<SitioAdapter.ViewHolderRegistro> {

    ArrayList<Sitio> registros;

    private Context context;

    public SitioAdapter(Context c, ArrayList<Sitio> r){

        this.registros = r;
        this.context = c;
    }

    @NonNull
    @Override
    public ViewHolderRegistro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.sitio_item,null,false);
        return new ViewHolderRegistro(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRegistro holder, int position) {

        //holder.txtNombre.setText(String.valueOf(this.nombre.get(position)));
        //holder.txtRadiacion.setText(String.valueOf(this.radiacion.get(position)));

    }

    @Override
   public int getItemCount() {
        return 0;
    }

    public class ViewHolderRegistro extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtRadiacion;
        TextView txtLatitud;

       public ViewHolderRegistro(@NonNull View itemView){
           super(itemView);
           //int id;
           this.txtNombre= itemView.findViewById(R.id.sitio_idnombre);
            //TextView txtCoordenadas;
           this.txtRadiacion= itemView.findViewById(R.id.sitio_radiacion);
           this.txtLatitud = itemView.findViewById(R.id.sitio_latitud);
       }
    }
}
