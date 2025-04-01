package azael.josue.controlador;

import java.util.ArrayList;
import java.util.List;
import azael.josue.Modelo.Habitacion;
import azael.josue.Modelo.TipoHabitacion;
import azael.josue.Modelo.EstadoHabitacion;

/**
 * Controlador que maneja la lógica de las habitaciones del hotel.
 * Se encarga de inicializar, buscar y mostrar información de las habitaciones.
 */
public class ControladorHabitaciones {
    private List<Habitacion> habitaciones;

    /**
     * Constructor que inicializa la lista de habitaciones y las crea.
     */
    public ControladorHabitaciones() {
        this.habitaciones = new ArrayList<>();
        inicializarHabitaciones();
    }

    /**
     * Crea todas las habitaciones del hotel, organizadas por pisos.
     * Cada piso tiene 5 habitaciones: 2 individuales, 2 dobles y 1 suite.
     */
    private void inicializarHabitaciones() {
        // Piso 1 (101-105)
        habitaciones.add(new Habitacion(101, 1, TipoHabitacion.INDIVIDUAL, 50.0));
        habitaciones.add(new Habitacion(102, 1, TipoHabitacion.INDIVIDUAL, 50.0));
        habitaciones.add(new Habitacion(103, 1, TipoHabitacion.DOBLE, 80.0));
        habitaciones.add(new Habitacion(104, 1, TipoHabitacion.DOBLE, 80.0));
        habitaciones.add(new Habitacion(105, 1, TipoHabitacion.SUITE, 150.0));

        // Piso 2 (201-205)
        habitaciones.add(new Habitacion(201, 2, TipoHabitacion.INDIVIDUAL, 50.0));
        habitaciones.add(new Habitacion(202, 2, TipoHabitacion.INDIVIDUAL, 50.0));
        habitaciones.add(new Habitacion(203, 2, TipoHabitacion.DOBLE, 80.0));
        habitaciones.add(new Habitacion(204, 2, TipoHabitacion.DOBLE, 80.0));
        habitaciones.add(new Habitacion(205, 2, TipoHabitacion.SUITE, 150.0));

        // Piso 3 (301-305)
        habitaciones.add(new Habitacion(301, 3, TipoHabitacion.INDIVIDUAL, 50.0));
        habitaciones.add(new Habitacion(302, 3, TipoHabitacion.INDIVIDUAL, 50.0));
        habitaciones.add(new Habitacion(303, 3, TipoHabitacion.DOBLE, 80.0));
        habitaciones.add(new Habitacion(304, 3, TipoHabitacion.DOBLE, 80.0));
        habitaciones.add(new Habitacion(305, 3, TipoHabitacion.SUITE, 150.0));
    }

    /**
     * Verifica si existe una habitación con el número especificado.
     * @param numero Número de habitación a buscar
     * @return true si la habitación existe, false en caso contrario
     */
    public boolean existeHabitacion(int numero) {
        return habitaciones.stream()
            .anyMatch(h -> h.getNumero() == numero);
    }

    /**
     * Obtiene el precio de una habitación por su número.
     * @param numero Número de habitación
     * @return Precio de la habitación, o 0.0 si no existe
     */
    public double getPrecioHabitacion(int numero) {
        return habitaciones.stream()
            .filter(h -> h.getNumero() == numero)
            .findFirst()
            .map(Habitacion::getPrecio)
            .orElse(0.0);
    }

    /**
     * Muestra todas las habitaciones del hotel en formato de tabla,
     * ordenadas por número de habitación.
     */
    public void mostrarTodasHabitaciones() {
        System.out.println("\n=== TODAS LAS HABITACIONES ===\n");
        System.out.println("NUM | PISO | TIPO       | PRECIO | ESTADO");
        System.out.println("----+------+------------+--------+--------");
        
        habitaciones.stream()
            .sorted((h1, h2) -> h1.getNumero() - h2.getNumero())
            .forEach(h -> System.out.printf("%3d | %-4d | %-10s | $%-6.0f| %s%n",
                h.getNumero(), h.getPiso(), h.getTipo(), h.getPrecio(), h.getEstado()));
        System.out.println();
    }

    /**
     * Muestra solo las habitaciones que están disponibles para reservar,
     * ordenadas por número de habitación.
     */
    public void mostrarHabitacionesDisponibles() {
        System.out.println("\n=== HABITACIONES DISPONIBLES ===\n");
        System.out.println("NUM | PISO | TIPO       | PRECIO");
        System.out.println("----+------+------------+--------");
        
        habitaciones.stream()
            .filter(h -> h.getEstado() == EstadoHabitacion.DISPONIBLE)
            .sorted((h1, h2) -> h1.getNumero() - h2.getNumero())
            .forEach(h -> System.out.printf("%3d | %-4d | %-10s | $%-6.0f%n",
                h.getNumero(), h.getPiso(), h.getTipo(), h.getPrecio()));
        System.out.println();
    }

    /**
     * Busca y devuelve una habitación por su número.
     * @param numero Número de habitación a buscar
     * @return La habitación encontrada o null si no existe
     */
    public Habitacion buscarHabitacion(int numero) {
        return habitaciones.stream()
            .filter(h -> h.getNumero() == numero)
            .findFirst()
            .orElse(null);
    }

    /**
     * Obtiene la lista completa de habitaciones.
     * @return Lista de todas las habitaciones del hotel
     */
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}
