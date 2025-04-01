package azael.josue.Modelo;

/**
 * Enumeración que define los diferentes tipos de habitaciones disponibles en el hotel.
 */
public enum TipoHabitacion {
    /** Habitación para una persona */
    INDIVIDUAL(50),
    
    /** Habitación para dos personas */
    DOBLE(80),
    
    /** Habitación de lujo con más espacio y comodidades */
    SUITE(150);
    
    // Declaramos la variable precio por noche
    private final double precioPorNoche;
    
    // Constructor con el parámetro de precio por noche
    TipoHabitacion(double precioPorNoche) {

        this.precioPorNoche = precioPorNoche; // Asignamos el valor
    }

    // Metodo para devolver el precio por noche
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
}
