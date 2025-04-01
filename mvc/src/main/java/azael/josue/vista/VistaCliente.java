package azael.josue.vista;

import java.util.Scanner;
import azael.josue.controlador.ControladorUsuario;
import azael.josue.excepciones.ClienteNoEncontradoException;

/**
 * Vista que maneja la interfaz de usuario para las operaciones relacionadas con clientes.
 * Permite ver la información de los clientes y sus reservas.
 */
public class VistaCliente {
    private final Scanner scanner;
    private final ControladorUsuario controladorUsuario;

    /**
     * Constructor que inicializa la vista de clientes.
     * @param controladorUsuario Controlador para manejar la lógica de usuarios
     * @param scanner Scanner compartido para entrada de usuario
     */
    public VistaCliente(ControladorUsuario controladorUsuario, Scanner scanner) {
        this.controladorUsuario = controladorUsuario;
        this.scanner = scanner;
    }

    /**
     * Muestra el menú principal de gestión de clientes y maneja la interacción del usuario.
     * Permite ver la información detallada de un cliente específico.
     */
    public void mostrarMenuCliente() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Ver información de cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        mostrarInformacionCliente();
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

    /**
     * Solicita el ID de un cliente y muestra su información detallada,
     * incluyendo sus reservas activas y el historial de reservas.
     */
    private void mostrarInformacionCliente() {
        try {
            System.out.print("\nIngrese el ID del cliente: ");
            int idCliente = Integer.parseInt(scanner.nextLine());
            controladorUsuario.mostrarInformacionCliente(idCliente);
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número válido");
        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
