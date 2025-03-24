package azael.josue.Modelo;

// Enumerador tipo de habitación y su precio
public enum TipoHabitacion {
    INDIVIDUAL(50),
    DOBLE(80),
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
