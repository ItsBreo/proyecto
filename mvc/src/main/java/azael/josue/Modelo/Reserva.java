package azael.josue.Modelo;

import java.util.Date;

public class Reserva {
    // Declaracion de variables
    private int id;
    private Habitacion habitacion;
    private Usuario usuario;
    private double precioTotal;
    private Date fechaCheckIn;
    private Date fechaCheckOut;
    
    // Constructor con sus características
    public Reserva(int id, Date fechaCheckIn, Date fechaCheckOut, Habitacion habitacion, double precioTotal, Usuario usuario) {
        this.id = id;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.habitacion = habitacion;
        this.precioTotal = precioTotal;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(Date fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public Date getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(Date fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", fechaCheckIn=" + fechaCheckIn + ", fechaCheckOut=" + fechaCheckOut + ", habitacion=" + habitacion + ", precioTotal=" + precioTotal + ", usuario=" + usuario + "]";
    }
}
