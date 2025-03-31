package azael.josue.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    public void mostrarMenu() {
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            while (op != 6 ) {
                System.out.println("\n\nGESTOR DE HABITACIONES DE HOTEL\n");
                System.out.println("1. Gestionar Habitaciones");
                System.out.println("2. Gestionar Usuarios");
                System.out.println("3. Gestionar Reservas");
                System.out.println("4. Salir");
                System.out.println("5. Entrar como admin");
                System.out.print("\nSeleccione una opción: ");
                op = scanner.nextInt();
                scanner.nextLine();            
            }
        } catch (InputMismatchException e) {
            System.out.println("\nError: Por favor, ingrese un número válido.");
        }
        scanner.close();
    }
}
