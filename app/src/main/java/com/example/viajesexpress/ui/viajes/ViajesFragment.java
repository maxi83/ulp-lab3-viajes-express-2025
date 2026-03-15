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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.viajesexpress.R;
import com.example.viajesexpress.databinding.FragmentViajesBinding;
import com.example.viajesexpress.model.Viaje;

import java.util.List;

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

        // IMPORTANTE: usar requireActivity para compartir el mismo ViewModel
        mv = new ViewModelProvider(requireActivity()).get(ViajesViewModel.class);

        binding.recyclerViajes.setLayoutManager(
                new LinearLayoutManager(getContext())
        );

        mv.getListaViajes().observe(getViewLifecycleOwner(), new Observer<List<Viaje>>() {
            @Override
            public void onChanged(List<Viaje> viajes) {

                ViajeAdapter adapter = new ViajeAdapter(
                        viajes,
                        getContext(),
                        getLayoutInflater()
                );

                binding.recyclerViajes.setAdapter(adapter);
            }
        });

        binding.btnCrearViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_viajes_to_crearViajeFragment);
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