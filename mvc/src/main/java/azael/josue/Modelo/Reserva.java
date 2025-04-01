package azael.josue.Modelo;

import java.time.LocalDate;

/**
 * Modelo que representa una reserva de habitación en el hotel.
 * Contiene información sobre el usuario que hace la reserva, la habitación reservada,
 * las fechas de entrada y salida, y el estado de la reserva.
 */
public class Reserva {
    private int id;
    private int idUsuario;
    private int numeroHabitacion;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private double precioTotal;
    private boolean cancelada;

    /**
     * Constructor que crea una nueva reserva.
     * @param id ID único de la reserva
     * @param idUsuario ID del usuario que hace la reserva
     * @param numeroHabitacion Número de la habitación reservada
     * @param fechaCheckIn Fecha de entrada
     * @param fechaCheckOut Fecha de salida
     * @param precioTotal Precio total de la reserva
     */
    public Reserva(int id, int idUsuario, int numeroHabitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut, double precioTotal) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.precioTotal = precioTotal;
        this.cancelada = false;
    }

    /**
     * Obtiene el ID de la reserva.
     * @return ID de la reserva
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el ID del usuario que hizo la reserva.
     * @return ID del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Obtiene el número de la habitación reservada.
     * @return Número de la habitación
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * Obtiene la fecha de entrada.
     * @return Fecha de check-in
     */
    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    /**
     * Obtiene la fecha de salida.
     * @return Fecha de check-out
     */
    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    /**
     * Obtiene el precio total de la reserva.
     * @return Precio total calculado
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Obtiene el estado actual de la reserva.
     * @return Estado de la reserva (true si está cancelada, false si está activa)
     */
    public boolean isCancelada() {
        return cancelada;
    }

    /**
     * Establece el estado de la reserva.
     * @param cancelada Nuevo estado de la reserva
     */
    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    @Override
    public String toString() {
        return String.format("Reserva %d - Habitación %d - Check-in: %s - Check-out: %s - Total: $%.2f - %s",
            id, numeroHabitacion, fechaCheckIn, fechaCheckOut, precioTotal, 
            cancelada ? "Cancelada" : "Activa");
    }
}