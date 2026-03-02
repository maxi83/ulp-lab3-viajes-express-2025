package com.example.viajesexpress.ui.viajes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ViajesFragment extends Fragment {

    private ViajesViewModel mv;

    public ViajesFragment() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mv = new ViewModelProvider(this).get(ViajesViewModel.class);

        return inflater.inflate(android.R.layout.simple_list_item_1, container, false);
    }
}