package azael.josue.vista;

import java.util.Scanner;

// Clases para la vista de reservas 
public class VistaReservas {

    private final Scanner scanner;

    // Constructor
    public VistaReservas() {
        this.scanner = new Scanner(System.in);
    }

    // Metodo para mostrar el menu de reservas
    public void mostrarMenu() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n=== GESTIÓN DE RESERVAS ===\n");
                System.out.println("1. Ver todas las reservas");
                System.out.println("2. Crear nueva reserva");
                System.out.println("3. Cancelar reserva");
                System.out.println("4. Buscar reserva por ID");
                System.out.println("5. Ver reservas activas de un cliente");
                System.out.println("0. Volver al menú principal");
                System.out.print("\nSeleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiamos el buffer

                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 0:
                        System.out.println("\nVolviendo al menú principal...");
                        break;
                    default:
                        System.out.println("\nOpción no válida. Por favor, seleccione una opción entre 1 y 5, o 0 para volver al menú principal.");
                }
            } catch (Exception e) {
                System.out.println("\nError: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }
}