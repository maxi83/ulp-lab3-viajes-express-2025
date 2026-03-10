package com.example.viajesexpress.ui.viajes;

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

import com.example.viajesexpress.databinding.FragmentViajesBinding;
import com.example.viajesexpress.model.Viaje;

import java.util.List;

/**
 * Fragment que muestra la lista de viajes.
 * Mismo patrón que Inmobiliaria.
 */
public class ViajesFragment extends Fragment {

    private ViajesViewModel mv;
    private FragmentViajesBinding binding;

    public ViajesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentViajesBinding.inflate(inflater, container, false);

        mv = new ViewModelProvider(this).get(ViajesViewModel.class);

        // Configura el RecyclerView en vertical
        binding.recyclerViajes.setLayoutManager(
                new LinearLayoutManager(getContext())
        );

        // Observa los datos del ViewModel
        mv.getListaViajes().observe(getViewLifecycleOwner(), new Observer<List<Viaje>>() {
            @Override
            public void onChanged(List<Viaje> viajes) {

                // EXACTAMENTE igual que Inmobiliaria:
                // crea adapter nuevo y lo asigna
                ViajeAdapter adapter = new ViajeAdapter(
                        viajes,
                        getContext(),
                        getLayoutInflater()
                );

                binding.recyclerViajes.setAdapter(adapter);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}