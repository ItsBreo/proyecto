package azael.josue.vista;

import java.util.List;
import azael.josue.Modelo.Habitacion;
import azael.josue.Modelo.EstadoHabitacion;

public class VistaHabitaciones {
    public void mostrarHabitaciones(List<Habitacion> habitaciones) {
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

    public void mostrarHabitacionesDisponibles(List<Habitacion> habitaciones) {
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

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);

    }
}
