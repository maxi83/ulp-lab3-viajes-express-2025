package com.example.viajesexpress.model;

public class Reserva {

    private int idReserva;
    private int idViaje;
    private int idUsuario;
    private int cantidadAsientos;
    private String estado;
    private String fechaReserva;

    public Reserva() {
    }

    public Reserva(int idReserva, int idViaje, int idUsuario, int cantidadAsientos, String estado, String fechaReserva) {
        this.idReserva = idReserva;
        this.idViaje = idViaje;
        this.idUsuario = idUsuario;
        this.cantidadAsientos = cantidadAsientos;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}