package azael.josue.vista;

import java.util.Scanner;
import azael.josue.controlador.*;
import azael.josue.Modelo.Usuario;

/**
 * Clase principal que maneja el menú principal del sistema de gestión hotelera.
 * Coordina la interacción entre las diferentes vistas y controladores.
 */
public class MenuPrincipal {
    private final Scanner scanner;
    private final ControladorHabitaciones controladorHabitaciones;
    private final ControladorUsuario controladorUsuario;
    private final ControladorReservas controladorReservas;
    private final VistaHabitaciones vistaHabitaciones;
    private final VistaCliente vistaCliente;
    private final VistaReservas vistaReservas;

    /**
     * Constructor que inicializa el menú principal y todos sus componentes.
     * Crea las instancias de controladores y vistas necesarias.
     */
    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.controladorHabitaciones = new ControladorHabitaciones();
        this.controladorReservas = new ControladorReservas(controladorHabitaciones);
        this.controladorUsuario = new ControladorUsuario(controladorReservas);
        this.vistaHabitaciones = new VistaHabitaciones(controladorHabitaciones, scanner);
        this.vistaCliente = new VistaCliente(controladorUsuario, scanner);
        this.vistaReservas = new VistaReservas(controladorReservas, controladorHabitaciones, scanner);
        
        // Crear usuario de ejemplo
        Usuario usuarioEjemplo = controladorUsuario.registrarUsuario("Cliente1", "123456");
        System.out.println("\n=== Usuario de ejemplo creado ===");
        System.out.println("ID: " + usuarioEjemplo.getId());
        System.out.println("Nombre: " + usuarioEjemplo.getNombre());
        System.out.println("==============================\n");
    }

    /**
     * Inicia la ejecución del programa mostrando el menú principal.
     * Permite al usuario navegar entre las diferentes opciones del sistema.
     */
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN HOTELERA ===");
            System.out.println("1. Gestión de habitaciones");
            System.out.println("2. Información de clientes");
            System.out.println("3. Gestión de reservas");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        vistaHabitaciones.mostrarMenuHabitaciones();
                        break;
                    case 2:
                        vistaCliente.mostrarMenuCliente();
                        break;
                    case 3:
                        vistaReservas.mostrarMenuReservas();
                        break;
                    case 0:
                        System.out.println("¡Gracias por usar nuestro sistema!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
