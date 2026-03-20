package com.example.viajesexpress.ui.reserva;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Viaje;
import com.example.viajesexpress.ui.viajes.ViajesViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReservaFragment extends Fragment {

    private ViajesViewModel mv;
    private TextView tvViajeSeleccionado;
    private EditText etCantidadAsientos;
    private Viaje viajeActual;

    public ReservaFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reserva, container, false);

        mv = new ViewModelProvider(requireActivity()).get(ViajesViewModel.class);

        tvViajeSeleccionado = view.findViewById(R.id.tvViajeSeleccionado);
        etCantidadAsientos = view.findViewById(R.id.etCantidadAsientos);

        mv.getViajeSeleccionado().observe(getViewLifecycleOwner(), viaje -> {
            viajeActual = viaje;

            if (viaje != null) {
                String texto = "Origen: " + viaje.getOrigen() +
                        "\nDestino: " + viaje.getDestino() +
                        "\nFecha: " + viaje.getFechaHora() +
                        "\nPrecio: $" + viaje.getPrecio() +
                        "\nAsientos disponibles: " + viaje.getAsientosDisponibles();

                tvViajeSeleccionado.setText(texto);
            }
        });

        view.findViewById(R.id.btnConfirmarReserva).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cantidadTexto = etCantidadAsientos.getText().toString().trim();

                if (viajeActual == null) {
                    Toast.makeText(getContext(), "No hay viaje seleccionado", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(cantidadTexto)) {
                    Toast.makeText(getContext(), "Ingrese la cantidad de asientos", Toast.LENGTH_SHORT).show();
                    return;
                }

                int cantidad = Integer.parseInt(cantidadTexto);

                if (cantidad <= 0) {
                    Toast.makeText(getContext(), "La cantidad debe ser mayor a 0", Toast.LENGTH_SHORT).show();
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String fechaActual = sdf.format(new Date());

                boolean resultado = mv.reservarViaje(viajeActual, cantidad, 1, fechaActual);

                if (resultado) {
                    Toast.makeText(getContext(), "Reserva realizada con éxito", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).navigateUp();
                } else {
                    Toast.makeText(getContext(), "No se pudo realizar la reserva", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}