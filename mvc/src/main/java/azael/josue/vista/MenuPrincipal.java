package azael.josue.vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import azael.josue.controlador.ControladorHabitaciones;

public class MenuPrincipal {
    public void mostrarMenu() {
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            while (op != 4) {
                System.out.println("\n\nGESTOR DE HABITACIONES DE HOTEL\n");
                System.out.println("1. Gestionar Habitaciones");
                System.out.println("2. Gestionar Usuarios");
                System.out.println("3. Gestionar Reservas");
                System.out.println("4. Salir");
                System.out.println("5. Entrar como admin");
                System.out.print("\nSeleccione una opción: ");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1:
                        ControladorHabitaciones controlador = new ControladorHabitaciones();
                        VistaHabitaciones vistaHabitaciones = new VistaHabitaciones(controlador, scanner);
                        vistaHabitaciones.mostrarMenuHabitaciones();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\n\nHasta luego, ¡vuelva pronto!\n\n");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opción fuera del rango 1-5.");
                        op = 0;
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un valor válido. (1-5)");
            scanner.nextLine();
        }
        scanner.close();
    }
}
