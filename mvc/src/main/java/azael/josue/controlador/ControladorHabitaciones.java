package azael.josue.controlador;

import java.util.ArrayList;
import java.util.List;
import azael.josue.Modelo.Habitacion;
import azael.josue.Modelo.TipoHabitacion;
import azael.josue.Modelo.EstadoHabitacion;

public class ControladorHabitaciones {
    private List<Habitacion> habitaciones;

    public ControladorHabitaciones() {
        this.habitaciones = new ArrayList<>();
        inicializarHabitaciones(); // Crear algunas habitaciones de ejemplo
    }

    private void inicializarHabitaciones() {
        // Primer piso (101-105)
        habitaciones.add(new Habitacion(101, TipoHabitacion.INDIVIDUAL, EstadoHabitacion.DISPONIBLE, "Vista al jardín"));
        habitaciones.add(new Habitacion(102, TipoHabitacion.DOBLE, EstadoHabitacion.OCUPADA, "Vista a la piscina"));
        habitaciones.add(new Habitacion(103, TipoHabitacion.SUITE, EstadoHabitacion.DISPONIBLE, "Suite ejecutiva"));
        habitaciones.add(new Habitacion(104, TipoHabitacion.DOBLE, EstadoHabitacion.RESERVADA, "Vista panorámica"));
        habitaciones.add(new Habitacion(105, TipoHabitacion.INDIVIDUAL, EstadoHabitacion.DISPONIBLE, "Vista al mar"));

        // Segundo piso (201-205)
        habitaciones.add(new Habitacion(201, TipoHabitacion.SUITE, EstadoHabitacion.DISPONIBLE, "Suite familiar"));
        habitaciones.add(new Habitacion(202, TipoHabitacion.DOBLE, EstadoHabitacion.OCUPADA, "Vista a la ciudad"));
        habitaciones.add(new Habitacion(203, TipoHabitacion.INDIVIDUAL, EstadoHabitacion.DISPONIBLE, "Vista al jardín"));
        habitaciones.add(new Habitacion(204, TipoHabitacion.SUITE, EstadoHabitacion.RESERVADA, "Suite premium"));
        habitaciones.add(new Habitacion(205, TipoHabitacion.DOBLE, EstadoHabitacion.DISPONIBLE, "Vista a la montaña"));

        // Tercer piso (301-305)
        habitaciones.add(new Habitacion(301, TipoHabitacion.SUITE, EstadoHabitacion.DISPONIBLE, "Suite presidencial"));
        habitaciones.add(new Habitacion(302, TipoHabitacion.DOBLE, EstadoHabitacion.DISPONIBLE, "Vista panorámica"));
        habitaciones.add(new Habitacion(303, TipoHabitacion.INDIVIDUAL, EstadoHabitacion.OCUPADA, "Vista al mar"));
        habitaciones.add(new Habitacion(304, TipoHabitacion.SUITE, EstadoHabitacion.RESERVADA, "Suite de lujo"));
        habitaciones.add(new Habitacion(305, TipoHabitacion.DOBLE, EstadoHabitacion.DISPONIBLE, "Vista a la ciudad"));
    }

    public void mostrarHabitaciones() {
        System.out.println("\n=== LISTADO DE HABITACIONES ===\n");
        System.out.println("N°  | TIPO          | ESTADO        | DESCRIPCIÓN");
        System.out.println("----+---------------+--------------+-------------");
        
        for (Habitacion habitacion : habitaciones) {
            System.out.printf("%-3d | %-13s | %-12s | %s%n", 
                habitacion.getNumero(), 
                habitacion.getTipo(),
                habitacion.getEstado(),
                habitacion.getDescripcion());
        }
        System.out.println("\n");
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("\n=== HABITACIONES DISPONIBLES ===\n");
        System.out.println("N°  | TIPO          | DESCRIPCIÓN");
        System.out.println("----+---------------+-------------");
        
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getEstado() == EstadoHabitacion.DISPONIBLE) {
                System.out.printf("%-3d | %-13s | %s%n", 
                    habitacion.getNumero(), 
                    habitacion.getTipo(),
                    habitacion.getDescripcion());
            }
        }
        System.out.println("\n");
    }

    public void cambiarEstadoHabitacion(int numeroHabitacion, EstadoHabitacion nuevoEstado) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                habitacion.setEstado(nuevoEstado);
                System.out.println("Estado de la habitación " + numeroHabitacion + 
                                   " actualizado a: " + nuevoEstado);
                return;
            }
        }
        System.out.println("No se encontró la habitación " + numeroHabitacion);
    }

    public void agregarHabitacion(int numero, TipoHabitacion tipo, EstadoHabitacion estado, String descripcion) {
        // Verificar si ya existe una habitación con ese número
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                System.out.println("Ya existe una habitación con el número " + numero);
                return;
            }
        }
        
        Habitacion nuevaHabitacion = new Habitacion(numero, tipo, estado, descripcion);
        habitaciones.add(nuevaHabitacion);
        System.out.println("Habitación agregada exitosamente");
    }

    public Habitacion buscarHabitacion(int numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }

    public List<Habitacion> filtrarPorTipo(TipoHabitacion tipo) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipo() == tipo) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        return habitacionesFiltradas;
    }

    public List<Habitacion> getHabitaciones() {
        return this.habitaciones;
    }
}
