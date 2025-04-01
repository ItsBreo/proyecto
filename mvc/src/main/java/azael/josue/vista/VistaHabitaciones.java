package azael.josue.vista;

import java.util.Scanner;
import azael.josue.controlador.ControladorHabitaciones;
import azael.josue.Modelo.Habitacion;

public class VistaHabitaciones {
    private ControladorHabitaciones controlador;
    private Scanner sc;

    // Constructor
    public VistaHabitaciones(ControladorHabitaciones controlador, Scanner sc){
        this.controlador = controlador;
        this.sc = sc;
    }

    public void mostrarMenuHabitaciones() {
        int op = -1;
        do {
            try {
                System.out.println("\n=== GESTIÓN DE HABITACIONES ===");
                System.out.println("1. Ver todas las habitaciones");
                System.out.println("2. Ver habitaciones disponibles");
                System.out.println("3. Buscar habitación por número");
                System.out.println("0. Volver al menú principal");
                System.out.print("Seleccione una opción: ");

                op = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\nError: Por favor, ingrese un número dentro del rango 0-3.");
                sc.nextLine();
                op = -1;
            }
            switch (op) {
                case 1:
                    mostrarTodasLasHabitaciones();
                break;
            case 2:
                mostrarHabitacionesDisponibles();
                break;
            case 3:
                buscarHabitacionPorNumero();
                break;
            case 0:
                return;
            default:
                System.out.println("\nError: Por favor, ingrese un número válido.");
                break;
        }
        } while (op!=0);
    }

    public void mostrarTodasLasHabitaciones() {
        System.out.println("\nLista de todas las habitaciones:");
        controlador.mostrarHabitaciones();
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("\nLista de habitaciones disponibles:");
        controlador.mostrarHabitacionesDisponibles();
    }

    public void buscarHabitacionPorNumero() {
        System.out.print("\nIngrese el número de la habitación: ");
        int numero = sc.nextInt();
        sc.nextLine();
        Habitacion habitacion = controlador.buscarHabitacion(numero);
        if (habitacion != null) {
            System.out.println("\nHabitación encontrada:");
            System.out.println(habitacion);
        } else {
            System.out.println("\nNo se encontró una habitación con el número: " + numero);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
