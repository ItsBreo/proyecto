package azael.josue.vista;

import java.util.Scanner;
import azael.josue.controlador.ControladorHabitaciones;

/**
 * Vista que maneja la interfaz de usuario para las operaciones relacionadas con habitaciones.
 * Permite ver todas las habitaciones y las que están disponibles.
 */
public class VistaHabitaciones {
    private final Scanner scanner;
    private final ControladorHabitaciones controladorHabitaciones;

    /**
     * Constructor que inicializa la vista de habitaciones.
     * @param controladorHabitaciones Controlador para manejar la lógica de habitaciones
     * @param scanner Scanner compartido para entrada de usuario
     */
    public VistaHabitaciones(ControladorHabitaciones controladorHabitaciones, Scanner scanner) {
        this.controladorHabitaciones = controladorHabitaciones;
        this.scanner = scanner;
    }

    /**
     * Muestra el menú principal de gestión de habitaciones y maneja la interacción del usuario.
     * Permite ver todas las habitaciones o solo las disponibles.
     */
    public void mostrarMenuHabitaciones() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE HABITACIONES ===");
            System.out.println("1. Ver todas las habitaciones");
            System.out.println("2. Ver habitaciones disponibles");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        controladorHabitaciones.mostrarTodasHabitaciones();
                        break;
                    case 2:
                        controladorHabitaciones.mostrarHabitacionesDisponibles();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
                opcion = -1;
            }
        } while (opcion != 0);
    }
}
