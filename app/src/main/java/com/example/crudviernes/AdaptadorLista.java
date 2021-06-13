package com.example.crudviernes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.viewHolder> {

    ArrayList<Usuario> listadeDatos;

    public AdaptadorLista(ArrayList<Usuario> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public AdaptadorLista.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItemLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);

        return new viewHolder(vistaDelItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLista.viewHolder holder, int position) {
        holder.actualizarDatos(listadeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView  nombreUsuario;
        TextView  edadUsuario;
        ImageView fotoUsuario;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombreUsuario=itemView.findViewById(R.id.nombreUsuario);
            edadUsuario=itemView.findViewById(R.id.edadUsuario);
            fotoUsuario=itemView.findViewById(R.id.foto);
        }

        public void actualizarDatos(Usuario usuario) {

            nombreUsuario.setText(usuario.getNombre());
            edadUsuario.setText(usuario.getEdad());

        }
    }
}