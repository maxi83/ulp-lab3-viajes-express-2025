package com.example.viajesexpress.ui.reserva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Reserva;

import java.util.List;

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.ViewHolder> {

    private List<Reserva> reservas;
    private LayoutInflater inflater;

    public ReservaAdapter(List<Reserva> reservas, LayoutInflater inflater) {
        this.reservas = reservas;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_reserva, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reserva reserva = reservas.get(position);

        holder.tvIdViaje.setText("Id viaje: " + reserva.getIdViaje());
        holder.tvCantidadAsientos.setText("Asientos reservados: " + reserva.getCantidadAsientos());
        holder.tvEstado.setText("Estado: " + reserva.getEstado());
        holder.tvFechaReserva.setText("Fecha: " + reserva.getFechaReserva());
    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdViaje;
        TextView tvCantidadAsientos;
        TextView tvEstado;
        TextView tvFechaReserva;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdViaje = itemView.findViewById(R.id.tvIdViaje);
            tvCantidadAsientos = itemView.findViewById(R.id.tvCantidadAsientos);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            tvFechaReserva = itemView.findViewById(R.id.tvFechaReserva);
        }
    }
}