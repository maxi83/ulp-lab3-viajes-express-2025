package com.example.viajesexpress.ui.viajes;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Viaje;

public class CrearViajeFragment extends Fragment {

    private ViajesViewModel mv;
    private EditText etOrigen, etDestino, etFecha, etPrecio, etAsientos;

    public CrearViajeFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crear_viaje, container, false);

        mv = new ViewModelProvider(requireActivity()).get(ViajesViewModel.class);

        etOrigen = view.findViewById(R.id.etOrigen);
        etDestino = view.findViewById(R.id.etDestino);
        etFecha = view.findViewById(R.id.etFecha);
        etPrecio = view.findViewById(R.id.etPrecio);
        etAsientos = view.findViewById(R.id.etAsientos);

        view.findViewById(R.id.btnGuardarViaje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String origen = etOrigen.getText().toString().trim();
                String destino = etDestino.getText().toString().trim();
                String fecha = etFecha.getText().toString().trim();
                String precioTexto = etPrecio.getText().toString().trim();
                String asientosTexto = etAsientos.getText().toString().trim();

                if (TextUtils.isEmpty(origen) || TextUtils.isEmpty(destino) || TextUtils.isEmpty(fecha)
                        || TextUtils.isEmpty(precioTexto) || TextUtils.isEmpty(asientosTexto)) {
                    Toast.makeText(getContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                double precio = Double.parseDouble(precioTexto);
                int asientos = Integer.parseInt(asientosTexto);

                Viaje viaje = new Viaje();
                viaje.setOrigen(origen);
                viaje.setDestino(destino);
                viaje.setFechaHora(fecha);
                viaje.setPrecio(precio);
                viaje.setAsientosDisponibles(asientos);
                viaje.setEstado("Publicado");

                mv.agregarViaje(viaje);

                Toast.makeText(getContext(), "Viaje guardado", Toast.LENGTH_SHORT).show();

                Navigation.findNavController(v).navigateUp();
            }
        });

        return view;
    }
}