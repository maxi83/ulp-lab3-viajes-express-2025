package com.example.viajesexpress.ui.viajes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viajesexpress.model.Reserva;
import com.example.viajesexpress.model.Viaje;

import java.util.ArrayList;
import java.util.List;

public class ViajesViewModel extends ViewModel {

    private MutableLiveData<List<Viaje>> listaViajes;
    private MutableLiveData<Viaje> viajeSeleccionado;
    private MutableLiveData<List<Reserva>> listaReservas;

    public ViajesViewModel() {

        listaViajes = new MutableLiveData<>();
        viajeSeleccionado = new MutableLiveData<>();
        listaReservas = new MutableLiveData<>();

        List<Viaje> lista = new ArrayList<>();

        Viaje v1 = new Viaje();
        v1.setIdViaje(1);
        v1.setOrigen("San Luis");
        v1.setDestino("Córdoba");
        v1.setFechaHora("12/06/2026");
        v1.setPrecio(3500);
        v1.setAsientosDisponibles(3);
        v1.setEstado("Publicado");

        Viaje v2 = new Viaje();
        v2.setIdViaje(2);
        v2.setOrigen("Mendoza");
        v2.setDestino("San Juan");
        v2.setFechaHora("15/06/2026");
        v2.setPrecio(4200);
        v2.setAsientosDisponibles(2);
        v2.setEstado("Publicado");

        Viaje v3 = new Viaje();
        v3.setIdViaje(3);
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
        listaReservas.setValue(new ArrayList<>());
    }

    public LiveData<List<Viaje>> getListaViajes() {
        return listaViajes;
    }

    public void agregarViaje(Viaje nuevoViaje) {
        List<Viaje> viajesActuales = listaViajes.getValue();

        if (viajesActuales == null) {
            viajesActuales = new ArrayList<>();
        }

        nuevoViaje.setIdViaje(viajesActuales.size() + 1);
        viajesActuales.add(nuevoViaje);

        listaViajes.setValue(viajesActuales);
    }

    public LiveData<Viaje> getViajeSeleccionado() {
        return viajeSeleccionado;
    }

    public void setViajeSeleccionado(Viaje viaje) {
        viajeSeleccionado.setValue(viaje);
    }

    public LiveData<List<Reserva>> getListaReservas() {
        return listaReservas;
    }

    public void agregarReserva(Reserva nuevaReserva) {
        List<Reserva> reservasActuales = listaReservas.getValue();

        if (reservasActuales == null) {
            reservasActuales = new ArrayList<>();
        }

        nuevaReserva.setIdReserva(reservasActuales.size() + 1);
        reservasActuales.add(nuevaReserva);

        listaReservas.setValue(reservasActuales);
    }

    public boolean reservarViaje(Viaje viaje, int cantidad, int idUsuario, String fechaReserva) {
        if (viaje == null || cantidad <= 0) {
            return false;
        }

        if (cantidad > viaje.getAsientosDisponibles()) {
            return false;
        }

        viaje.setAsientosDisponibles(viaje.getAsientosDisponibles() - cantidad);
        listaViajes.setValue(listaViajes.getValue());

        Reserva reserva = new Reserva();
        reserva.setIdViaje(viaje.getIdViaje());
        reserva.setIdUsuario(idUsuario);
        reserva.setCantidadAsientos(cantidad);
        reserva.setEstado("Confirmada");
        reserva.setFechaReserva(fechaReserva);

        agregarReserva(reserva);

        return true;
    }
}