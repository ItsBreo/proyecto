package azael.josue.Modelo;

/**
 * Modelo que representa una habitación del hotel.
 * Contiene información sobre el número, piso, tipo, precio y estado de la habitación.
 */
public class Habitacion {
    // Declaracion de variables
    private int numero;
    private int piso;
    private TipoHabitacion tipo;
    private double precio;
    private EstadoHabitacion estado;
    private String descripcion;

    /**
     * Constructor que crea una nueva habitación.
     * @param numero Número de la habitación (formato: piso + número, ej: 101)
     * @param piso Piso donde se encuentra la habitación (1-3)
     * @param tipo Tipo de habitación (INDIVIDUAL, DOBLE, SUITE)
     * @param precio Precio por noche de la habitación
     */
    public Habitacion(int numero, int piso, TipoHabitacion tipo, double precio) {
        this.numero = numero;
        this.piso = piso;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = EstadoHabitacion.DISPONIBLE;
        this.descripcion = String.format("Habitación %s en piso %d", tipo, piso);
    }

    /**
     * Obtiene el número de la habitación.
     * @return Número de la habitación
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la habitación.
     * @param numero Nuevo número de la habitación
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el piso donde se encuentra la habitación.
     * @return Número de piso
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Establece el piso donde se encuentra la habitación.
     * @param piso Nuevo piso de la habitación
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Obtiene el tipo de habitación.
     * @return Tipo de habitación (INDIVIDUAL, DOBLE, SUITE)
     */
    public TipoHabitacion getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de habitación.
     * @param tipo Nuevo tipo de habitación
     */
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el precio por noche de la habitación.
     * @return Precio de la habitación
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio por noche de la habitación.
     * @param precio Nuevo precio de la habitación
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el estado actual de la habitación.
     * @return Estado de la habitación (DISPONIBLE, OCUPADA)
     */
    public EstadoHabitacion getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la habitación.
     * @param estado Nuevo estado de la habitación
     */
    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la descripción de la habitación.
     * @return Descripción detallada de la habitación
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la habitación.
     * @param descripcion Nueva descripción de la habitación
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("Habitación %d - %s - Piso %d - $%.2f - %s", 
            numero, tipo, piso, precio, estado);
    }
}