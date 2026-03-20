package com.example.viajesexpress.ui.reserva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viajesexpress.R;
import com.example.viajesexpress.model.Reserva;
import com.example.viajesexpress.ui.viajes.ViajesViewModel;

import java.util.List;

public class MisReservasFragment extends Fragment {

    private ViajesViewModel mv;
    private RecyclerView recyclerMisReservas;

    public MisReservasFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mis_reservas, container, false);

        mv = new ViewModelProvider(requireActivity()).get(ViajesViewModel.class);

        recyclerMisReservas = view.findViewById(R.id.recyclerMisReservas);
        recyclerMisReservas.setLayoutManager(new LinearLayoutManager(getContext()));

        mv.getListaReservas().observe(getViewLifecycleOwner(), new Observer<List<Reserva>>() {
            @Override
            public void onChanged(List<Reserva> reservas) {
                ReservaAdapter adapter = new ReservaAdapter(reservas, getLayoutInflater());
                recyclerMisReservas.setAdapter(adapter);
            }
        });

        return view;
    }
}