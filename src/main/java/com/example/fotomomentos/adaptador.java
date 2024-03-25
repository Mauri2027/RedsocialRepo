package com.example.fotomomentos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class adaptador extends
        RecyclerView.Adapter<adaptador.UsuariosViewholder> implements View.OnClickListener {
    ArrayList<UsuarioV> listaUsuarios;
    private View.OnClickListener listener;


    public adaptador(ArrayList<UsuarioV> listaUsuarios){

        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuariosViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);
        view.setOnClickListener(this);
        return new UsuariosViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewholder holder, int position) {
        holder.txtNombre.setText(listaUsuarios.get(position).getNombre());
        holder.txtDescripcion.setText(listaUsuarios.get(position).getDescripcion());
        holder.foto.setImageResource(listaUsuarios.get(position).getImagenId());

    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }


    public class UsuariosViewholder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtDescripcion;
        ImageView foto;

        public UsuariosViewholder(@NonNull View itemView) {
            super(itemView);
            txtNombre= itemView.findViewById(R.id.tituloitem);
            txtDescripcion=itemView.findViewById(R.id.descripcionitem);
            foto=itemView.findViewById(R.id.fotoitem);
        }
    }
}
