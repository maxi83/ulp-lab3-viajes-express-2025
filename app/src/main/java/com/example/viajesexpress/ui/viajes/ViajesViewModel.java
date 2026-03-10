package com.example.viajesexpress.ui.viajes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viajesexpress.model.Viaje;

import java.util.ArrayList;
import java.util.List;

public class ViajesViewModel extends ViewModel {

    private MutableLiveData<List<Viaje>> listaViajes;

    public ViajesViewModel() {

        listaViajes = new MutableLiveData<>();

        List<Viaje> lista = new ArrayList<>();

        Viaje v1 = new Viaje();
        v1.setOrigen("San Luis");
        v1.setDestino("Córdoba");
        v1.setFechaHora("12/06/2026");
        v1.setPrecio(3500);
        v1.setAsientosDisponibles(3);
        v1.setEstado("Publicado");

        Viaje v2 = new Viaje();
        v2.setOrigen("Mendoza");
        v2.setDestino("San Juan");
        v2.setFechaHora("15/06/2026");
        v2.setPrecio(4200);
        v2.setAsientosDisponibles(2);
        v2.setEstado("Publicado");

        Viaje v3 = new Viaje();
        v3.setOrigen("Buenos Aires");
        v3.setDestino("Rosario");
        v3.setFechaHora("20/06/2026");
        v3.setPrecio(5000);
        v3.setAsientosDisponibles(4);
        v3.setEstado("Publicado");

        lista.add(v1);
        lista.add(v2);
        lista.add(v3);

        listaViajes.setValue(lista);
    }

    public LiveData<List<Viaje>> getListaViajes() {
        return listaViajes;
    }

    public void agregarViaje(Viaje nuevoViaje) {

        List<Viaje> viajesActuales = listaViajes.getValue();

        if (viajesActuales == null) {
            viajesActuales = new ArrayList<>();
        }

        viajesActuales.add(nuevoViaje);

        listaViajes.setValue(viajesActuales);
    }
}