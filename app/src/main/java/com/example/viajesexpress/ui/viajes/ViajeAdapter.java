package com.example.viajesexpress.ui.viajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Viaje;

import java.util.List;

/**
 * Adapter que conecta la lista de viajes con el RecyclerView
 */
public class ViajeAdapter extends RecyclerView.Adapter<ViajeAdapter.ViewHolder> {

    private List<Viaje> viajes;
    private Context context;
    private LayoutInflater inflater;

    // 🔥 Constructor que recibe los datos
    public ViajeAdapter(List<Viaje> viajes, Context context, LayoutInflater inflater) {
        this.viajes = viajes;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Infla el layout de cada item
        View view = inflater.inflate(R.layout.item_viaje, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Obtiene el viaje actual
        Viaje viaje = viajes.get(position);

        // Aquí luego pondremos los datos en los TextView
        // holder.tvOrigen.setText(viaje.getOrigen());
    }

    @Override
    public int getItemCount() {
        return viajes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}