package azael.josue.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import azael.josue.controlador.ControladorReservas;
import azael.josue.controlador.ControladorHabitaciones;
import azael.josue.excepciones.ReservaNoDisponibleException;

public class VistaReservas {
    private final Scanner scanner;
    private final ControladorReservas controladorReservas;
    private final ControladorHabitaciones controladorHabitaciones;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VistaReservas(ControladorReservas controladorReservas, ControladorHabitaciones controladorHabitaciones, Scanner scanner) {
        this.controladorReservas = controladorReservas;
        this.controladorHabitaciones = controladorHabitaciones;
        this.scanner = scanner;
    }

    public void mostrarMenuReservas() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE RESERVAS ===");
            System.out.println("1. Crear reserva");
            System.out.println("2. Ver mis reservas activas");
            System.out.println("3. Ver historial de reservas");
            System.out.println("4. Cancelar reserva");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        crearReserva();
                        break;
                    case 2:
                        controladorReservas.mostrarReservasActivas(1);
                        break;
                    case 3:
                        controladorReservas.mostrarHistorialReservas(1);
                        break;
                    case 4:
                        cancelarReserva();
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

    private void crearReserva() {
        try {
            System.out.print("\nIngrese el número de habitación: ");
            int numeroHabitacion = Integer.parseInt(scanner.nextLine());

            if (!controladorHabitaciones.existeHabitacion(numeroHabitacion)) {
                System.out.println("Error: La habitación no existe");
                return;
            }

            System.out.print("Ingrese la fecha de check-in (dd/MM/yyyy): ");
            LocalDate fechaCheckIn = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.print("Ingrese la fecha de check-out (dd/MM/yyyy): ");
            LocalDate fechaCheckOut = LocalDate.parse(scanner.nextLine(), formatter);

            controladorReservas.crearReserva(1, numeroHabitacion, fechaCheckIn, fechaCheckOut);
            System.out.println("\n¡Reserva creada exitosamente!");

        } catch (NumberFormatException e) {
            System.out.println("Error: El número de habitación debe ser un número válido");
        } catch (DateTimeParseException e) {
            System.out.println("Error: El formato de fecha debe ser dd/MM/yyyy");
        } catch (ReservaNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancelarReserva() {
        try {
            System.out.print("\nIngrese el ID de la reserva a cancelar: ");
            int idReserva = Integer.parseInt(scanner.nextLine());
            controladorReservas.cancelarReserva(idReserva);
            System.out.println("Reserva cancelada exitosamente");
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID debe ser un número válido");
        }
    }
}