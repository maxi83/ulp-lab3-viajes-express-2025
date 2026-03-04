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

/*
 * Fragment que muestra la lista de viajes.
 *
 * Responsabilidad:
 * - Inflar la vista
 * - Observar el ViewModel
 * - Configurar el RecyclerView
 *
 * NO debe contener lógica de negocio.
 */
public class ViajesFragment extends Fragment {

    // ViewModel del módulo viajes
    private ViajesViewModel mv;

    // ViewBinding para acceder a los componentes del XML sin findViewById
    private FragmentViajesBinding binding;

    // Constructor vacío obligatorio
    public ViajesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inicializamos el binding (infla el layout automáticamente)
        binding = FragmentViajesBinding.inflate(inflater, container, false);

        // Inicializamos el ViewModel asociado a este Fragment
        mv = new ViewModelProvider(this).get(ViajesViewModel.class);

        // Configuramos el LayoutManager del RecyclerView
        // LinearLayoutManager muestra los items en forma vertical
        binding.recyclerViajes.setLayoutManager(
                new LinearLayoutManager(getContext())
        );

        // Observamos la lista de viajes del ViewModel
        mv.getListaViajes().observe(getViewLifecycleOwner(), new Observer<List<Viaje>>() {
            @Override
            public void onChanged(List<Viaje> viajes) {

                // Cada vez que cambie la lista,
                // se crea un nuevo Adapter con los datos actualizados
                ViajeAdapter adapter = new ViajeAdapter(viajes, getContext(), getLayoutInflater());

                // Se asigna el adapter al RecyclerView
                binding.recyclerViajes.setAdapter(adapter);
            }
        });

        // Devolvemos la vista raíz
        return binding.getRoot();
    }

    /*
     * Liberamos el binding cuando la vista se destruye
     * para evitar memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}