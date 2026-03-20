package com.example.viajesexpress.ui.viajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Viaje;

import java.util.List;

public class ViajeAdapter extends RecyclerView.Adapter<ViajeAdapter.ViewHolder> {

    private List<Viaje> viajes;
    private Context context;
    private LayoutInflater inflater;
    private ViajesViewModel mv;

    public ViajeAdapter(List<Viaje> viajes, Context context, LayoutInflater inflater, ViajesViewModel mv) {
        this.viajes = viajes;
        this.context = context;
        this.inflater = inflater;
        this.mv = mv;
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
        holder.tvFecha.setText("Fecha: " + viaje.getFechaHora());
        holder.tvPrecio.setText("Precio: $" + viaje.getPrecio());
        holder.tvAsientos.setText("Asientos: " + viaje.getAsientosDisponibles());

        holder.btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.setViajeSeleccionado(viaje);
                Navigation.findNavController(v).navigate(R.id.action_nav_viajes_to_reservaFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrigen;
        TextView tvDestino;
        TextView tvFecha;
        TextView tvPrecio;
        TextView tvAsientos;
        Button btnReservar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrigen = itemView.findViewById(R.id.tvOrigen);
            tvDestino = itemView.findViewById(R.id.tvDestino);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvAsientos = itemView.findViewById(R.id.tvAsientos);
            btnReservar = itemView.findViewById(R.id.btnReservar);
        }
    }
}