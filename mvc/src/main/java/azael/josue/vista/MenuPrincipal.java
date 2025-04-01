package azael.josue.vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import azael.josue.controlador.ControladorHabitaciones;
import azael.josue.controlador.ControladorUsuario;

public class MenuPrincipal {
    private Scanner scanner;
    private ControladorHabitaciones controladorHabitaciones;
    private ControladorUsuario controladorUsuario;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.controladorHabitaciones = new ControladorHabitaciones();
        this.controladorUsuario = new ControladorUsuario();
    }

    public void mostrarMenu() {
        int op = 0;
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
                        VistaHabitaciones vistaHabitaciones = new VistaHabitaciones(controladorHabitaciones, scanner);
                        vistaHabitaciones.mostrarMenuHabitaciones();
                        break;
                    case 2:
                        VistaCliente vistaCliente = new VistaCliente(controladorUsuario, scanner);
                        vistaCliente.mostrarMenuCliente();
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\n\nHasta luego, ¡vuelva pronto!\n\n");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("\nError: Por favor, ingrese un número dentro del rango 1-5.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\nError: Por favor, ingrese un número válido. (1-5)");
            scanner.nextLine();
            mostrarMenu();
        }
    }
}
