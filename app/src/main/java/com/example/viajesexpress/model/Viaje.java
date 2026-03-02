package com.example.viajesexpress.model;

// Clase que representa la entidad Viaje dentro de la aplicación.
// Esta clase es el modelo de dominio que luego va a coincidir
// con la entidad del backend (.NET + MySQL).
public class Viaje {

    // Identificador único del viaje (clave primaria en base de datos)
    private int idViaje;

    // Usuario que creó el viaje (relación 1:N en el DER)
    private int idUsuario;

    // Ciudad o lugar de origen del viaje
    private String origen;

    // Ciudad o lugar de destino
    private String destino;

    // Fecha y hora del viaje (por ahora como String,
    // más adelante puede ser LocalDateTime cuando conectemos con API)
    private String fechaHora;

    // Precio del viaje
    private double precio;

    // Cantidad de asientos disponibles
    private int asientosDisponibles;

    // Estado del viaje (ej: publicado, cancelado, completado)
    private String estado;


    // Constructor vacío obligatorio.
    // Es necesario para que librerías como Retrofit o Gson
    // puedan instanciar la clase automáticamente.
    public Viaje() {
    }

    // Constructor completo.
    // Permite crear un objeto Viaje con todos sus atributos.
    public Viaje(int idViaje, int idUsuario, String origen, String destino,
                 String fechaHora, double precio, int asientosDisponibles, String estado) {
        this.idViaje = idViaje;
        this.idUsuario = idUsuario;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.precio = precio;
        this.asientosDisponibles = asientosDisponibles;
        this.estado = estado;
    }

    // Getter devuelve el id del viaje
    public int getIdViaje() {
        return idViaje;
    }

    // Setter asigna el id del viaje
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    // Getter del usuario creador
    public int getIdUsuario() {
        return idUsuario;
    }

    // Setter del usuario creador
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Getter del origen
    public String getOrigen() {
        return origen;
    }

    // Setter del origen
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    // Getter del destino
    public String getDestino() {
        return destino;
    }

    // Setter del destino
    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Getter de la fecha y hora
    public String getFechaHora() {
        return fechaHora;
    }

    // Setter de la fecha y hora
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    // Getter del precio
    public double getPrecio() {
        return precio;
    }

    // Setter del precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getter de asientos disponibles
    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    // Setter de asientos disponibles
    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    // Getter del estado del viaje
    public String getEstado() {
        return estado;
    }

    // Setter del estado del viaje
    public void setEstado(String estado) {
        this.estado = estado;
    }
}