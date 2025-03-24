package azael.josue.Modelo;

public class Habitacion {
    // Declaracion de variables
    private int numero;
    private TipoHabitacion tipo;
    private EstadoHabitacion estado;
    private String descripcion;

    // Constructor con sus características de habitacion
    public Habitacion(int numero, TipoHabitacion tipo, String descripcion) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = EstadoHabitacion.DISPONIBLE;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}