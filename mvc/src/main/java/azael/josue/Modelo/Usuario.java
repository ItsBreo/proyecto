package azael.josue.Modelo;

import java.util.ArrayList;

public class Usuario {
    // Declaracion de variables
    private String nombre;
    private int id;
    private Reserva idReserva;
    private ArrayList<Reserva> historialReservas;
    private final int maximasReservas = 3;

    // Constructor con sus características
    public Usuario(String nombre, Reserva idReserva, ArrayList<Reserva> historialReservas) {
        this.nombre = nombre;
        this.idReserva = idReserva;
        this.historialReservas = historialReservas;
    }

    // Getters y Setters    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public ArrayList<Reserva> getHistorialReservas() {
        return historialReservas;
    }

    public void setHistorialReservas(ArrayList<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }
    
    public boolean puedeHacerReserva() {
        return historialReservas.size() < maximasReservas;
    }
    
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", id=" + id + ", idReserva=" + idReserva + ", historialReservas=" + historialReservas + "]";
    }
}