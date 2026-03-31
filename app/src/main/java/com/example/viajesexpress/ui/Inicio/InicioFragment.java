package com.example.viajesexpress.ui.Inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.viajesexpress.R;

public class InicioFragment extends Fragment {

    private Button btnVerViajes;
    private Button btnMisReservas;

    public InicioFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        btnVerViajes = view.findViewById(R.id.btnVerViajes);
        btnMisReservas = view.findViewById(R.id.btnMisReservas);

        btnVerViajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_viajes);
            }
        });

        btnMisReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.misReservasFragment);
            }
        });

        return view;
    }
}