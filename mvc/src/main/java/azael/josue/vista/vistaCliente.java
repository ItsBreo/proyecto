package azael.josue.vista;

import java.util.ArrayList;
import azael.josue.Modelo.Usuario;
import azael.josue.Modelo.Reserva;

public class vistaCliente {
    
    public void mostrarInformacionCliente(Usuario usuario) {
        if (usuario != null) {
            System.out.println("\n=== Información del Cliente ===");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("ID: " + usuario.getId());
            System.out.println("Reserva Actual: " + (usuario.getIdReserva() != null ? 
                             usuario.getIdReserva().toString() : "Sin reserva actual"));
            
            System.out.println("\nHistorial de Reservas:");
            ArrayList<Reserva> historial = usuario.getHistorialReservas();
            if (historial != null && !historial.isEmpty()) {
                for (Reserva reserva : historial) {
                    System.out.println("- " + reserva.toString());
                }
            } else {
                System.out.println("No hay reservas en el historial");
            }
            System.out.println("==============================\n");
        } else {
            System.out.println("No se ha encontrado información del cliente");
        }
    }
}
