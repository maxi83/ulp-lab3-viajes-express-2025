package com.example.viajesexpress.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroViewModel extends ViewModel {

    private final MutableLiveData<String> mensajeRegistro = new MutableLiveData<>();
    private final MutableLiveData<Boolean> registroExitoso = new MutableLiveData<>();

    public LiveData<String> getMensajeRegistro() {
        return mensajeRegistro;
    }

    public LiveData<Boolean> getRegistroExitoso() {
        return registroExitoso;
    }

    public void validarRegistro(String nombre, String email, String password) {
        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
            mensajeRegistro.setValue("Complete todos los campos.");
            registroExitoso.setValue(false);
        } else {
            mensajeRegistro.setValue("Usuario registrado correctamente.");
            registroExitoso.setValue(true);
        }
    }
}