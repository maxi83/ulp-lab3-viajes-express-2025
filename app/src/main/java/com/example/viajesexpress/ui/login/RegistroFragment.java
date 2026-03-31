package com.example.viajesexpress.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viajesexpress.R;

public class RegistroFragment extends Fragment {

    private EditText etNombre;
    private EditText etEmailRegistro;
    private EditText etPasswordRegistro;
    private Button btnRegistrarse;
    private TextView tvMensajeRegistro;
    private TextView tvVolverLogin;
    private RegistroViewModel registroViewModel;

    public RegistroFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        etNombre = view.findViewById(R.id.etNombre);
        etEmailRegistro = view.findViewById(R.id.etEmailRegistro);
        etPasswordRegistro = view.findViewById(R.id.etPasswordRegistro);
        btnRegistrarse = view.findViewById(R.id.btnRegistrarse);
        tvMensajeRegistro = view.findViewById(R.id.tvMensajeRegistro);
        tvVolverLogin = view.findViewById(R.id.tvVolverLogin);

        registroViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);

        registroViewModel.getMensajeRegistro().observe(getViewLifecycleOwner(), mensaje -> {
            tvMensajeRegistro.setText(mensaje);
        });

        registroViewModel.getRegistroExitoso().observe(getViewLifecycleOwner(), exito -> {
            if (exito) {
                Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etNombre.getText().toString().trim();
                String email = etEmailRegistro.getText().toString().trim();
                String password = etPasswordRegistro.getText().toString().trim();

                registroViewModel.validarRegistro(nombre, email, password);
            }
        });

        tvVolverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}