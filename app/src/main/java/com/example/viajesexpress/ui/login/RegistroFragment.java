package com.example.viajesexpress.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viajesexpress.R;

public class RegistroFragment extends Fragment {

    private EditText etNombre;
    private EditText etEmailRegistro;
    private EditText etPasswordRegistro;
    private Button btnRegistrarse;
    private TextView tvMensajeRegistro;

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

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = etNombre.getText().toString().trim();
                String email = etEmailRegistro.getText().toString().trim();
                String password = etPasswordRegistro.getText().toString().trim();

                if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    tvMensajeRegistro.setText("Complete todos los campos.");
                    return;
                }

                tvMensajeRegistro.setText("Usuario registrado correctamente.");
                Toast.makeText(getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();

                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}