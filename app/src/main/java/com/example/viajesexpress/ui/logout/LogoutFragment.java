package com.example.viajesexpress.ui.logout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viajesexpress.R;

public class LogoutFragment extends Fragment {

    public LogoutFragment() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Infla el layout fragment_logout.xml
        View view = inflater.inflate(R.layout.fragment_logout, container, false);

        // Cierra la aplicación
        requireActivity().finish();

        return view;
    }
}