package com.example.viajesexpress.ui.viajes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viajesexpress.model.Viaje;

import java.util.ArrayList;
import java.util.List;

/*
 * ViewModel del módulo Viajes.
 *
 * Su responsabilidad es:
 * - Mantener la lista de viajes en memoria.
 * - Sobrevivir a rotaciones de pantalla.
 * - Permitir agregar nuevos viajes dinámicamente.
 */
public class ViajesViewModel extends ViewModel {

    // Lista observable de viajes.
    // MutableLiveData permite modificar el valor internamente.
    private MutableLiveData<List<Viaje>> listaViajes;

    /*
     * Constructor del ViewModel.
     * Inicializa la lista vacía.
     */
    public ViajesViewModel() {
        listaViajes = new MutableLiveData<>();

        // Inicializamos con una lista vacía (sin hardcodeo)
        listaViajes.setValue(new ArrayList<>());
    }

    /*
     * Devuelve la lista observable.
     * El Fragment solo puede observar, no modificar.
     */
    public LiveData<List<Viaje>> getListaViajes() {
        return listaViajes;
    }

    /*
     * Método para agregar un nuevo viaje.
     * Este método será llamado desde la pantalla Crear Viaje.
     */
    public void agregarViaje(Viaje nuevoViaje) {

        // Obtenemos la lista actual
        List<Viaje> viajesActuales = listaViajes.getValue();

        // Si por alguna razón es null, la inicializamos
        if (viajesActuales == null) {
            viajesActuales = new ArrayList<>();
        }

        // Agregamos el nuevo viaje a la lista
        viajesActuales.add(nuevoViaje);

        // Notificamos a los observadores que cambió la lista
        listaViajes.setValue(viajesActuales);
    }
}