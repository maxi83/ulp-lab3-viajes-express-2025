package com.example.viajesexpress.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.viajesexpress.LoginActivity;
import com.example.viajesexpress.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginViewModel.getMensajeError().observe(getViewLifecycleOwner(), mensaje -> {
            binding.tvError.setText(mensaje);
        });

        loginViewModel.getLoginExitoso().observe(getViewLifecycleOwner(), exito -> {
            if (exito) {
                binding.tvError.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                ((LoginActivity) requireActivity()).irAMain();
            } else {
                binding.tvError.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            }
        });

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();
            loginViewModel.validarLogin(email, password);
        });

        binding.tvRegistrate.setOnClickListener(v -> {
            ((LoginActivity) requireActivity()).irARegistro();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}