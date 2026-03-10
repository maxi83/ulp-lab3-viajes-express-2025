package com.example.viajesexpress.ui.viajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Viaje;

import java.util.List;

public class ViajeAdapter extends RecyclerView.Adapter<ViajeAdapter.ViewHolder> {

    private List<Viaje> viajes;
    private Context context;
    private LayoutInflater inflater;

    public ViajeAdapter(List<Viaje> viajes, Context context, LayoutInflater inflater) {
        this.viajes = viajes;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_viaje, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Viaje viaje = viajes.get(position);

        holder.tvOrigen.setText("Origen: " + viaje.getOrigen());
        holder.tvDestino.setText("Destino: " + viaje.getDestino());
    }

    @Override
    public int getItemCount() {
        return viajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrigen;
        TextView tvDestino;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrigen = itemView.findViewById(R.id.tvOrigen);
            tvDestino = itemView.findViewById(R.id.tvDestino);
        }
    }
}