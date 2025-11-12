package com.example.viajesexpress.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<String> mensajeError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loginExitoso = new MutableLiveData<>();

    public LiveData<String> getMensajeError() {
        return mensajeError;
    }

    public LiveData<Boolean> getLoginExitoso() {
        return loginExitoso;
    }

    // Lógica simple de validación (sin API todavía)
    public void validarLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            mensajeError.setValue("Por favor, complete todos los campos.");
            loginExitoso.setValue(false);
        } else if (email.equals("admin@ulp.edu.ar") && password.equals("1234")) {
            mensajeError.setValue("Inicio de sesión exitoso.");
            loginExitoso.setValue(true);
        } else {
            mensajeError.setValue("Credenciales incorrectas.");
            loginExitoso.setValue(false);
        }
    }
}
