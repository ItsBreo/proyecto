package azael.josue.controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import azael.josue.Modelo.Reserva;
import azael.josue.excepciones.ReservaNoDisponibleException;

/**
 * Controlador que maneja la lógica de las reservas del hotel.
 * Se encarga de crear, cancelar y mostrar información de las reservas.
 */
public class ControladorReservas {
    private List<Reserva> reservas;
    private final ControladorHabitaciones controladorHabitaciones;
    private int nextId = 1;

    /**
     * Constructor que inicializa la lista de reservas y recibe el controlador de habitaciones.
     * @param controladorHabitaciones Controlador para gestionar las habitaciones
     */
    public ControladorReservas(ControladorHabitaciones controladorHabitaciones) {
        this.reservas = new ArrayList<>();
        this.controladorHabitaciones = controladorHabitaciones;
    }

    /**
     * Crea una nueva reserva para un usuario y habitación específicos.
     * @param idUsuario ID del usuario que hace la reserva
     * @param numeroHabitacion Número de la habitación a reservar
     * @param fechaCheckIn Fecha de entrada
     * @param fechaCheckOut Fecha de salida
     * @return La reserva creada
     * @throws ReservaNoDisponibleException si la habitación no está disponible
     */
    public Reserva crearReserva(int idUsuario, int numeroHabitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut) throws ReservaNoDisponibleException {
        // Validar fechas
        if (fechaCheckIn.isBefore(LocalDate.now())) {
            throw new ReservaNoDisponibleException("La fecha de check-in no puede ser anterior a hoy");
        }
        if (fechaCheckOut.isBefore(fechaCheckIn)) {
            throw new ReservaNoDisponibleException("La fecha de check-out no puede ser anterior a la fecha de check-in");
        }
        
        // Validar disponibilidad de la habitación
        if (!habitacionDisponible(numeroHabitacion, fechaCheckIn, fechaCheckOut)) {
            throw new ReservaNoDisponibleException("La habitación no está disponible para las fechas seleccionadas");
        }

        // Validar límite de reservas activas
        if (getReservasActivas(idUsuario).size() >= 3) {
            throw new ReservaNoDisponibleException("El usuario ya tiene el máximo de reservas activas permitidas (3)");
        }

        // Calcular precio total
        double precioNoche = controladorHabitaciones.getPrecioHabitacion(numeroHabitacion);
        long numNoches = fechaCheckIn.until(fechaCheckOut).getDays();
        double precioTotal = precioNoche * numNoches;

        // Crear la reserva
        Reserva reserva = new Reserva(nextId++, idUsuario, numeroHabitacion, fechaCheckIn, fechaCheckOut, precioTotal);
        reservas.add(reserva);
        return reserva;
    }

    /**
     * Verifica si una habitación está disponible para un rango de fechas.
     * @param numeroHabitacion Número de la habitación
     * @param fechaCheckIn Fecha de entrada
     * @param fechaCheckOut Fecha de salida
     * @return true si la habitación está disponible
     */
    public boolean habitacionDisponible(int numeroHabitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
        return reservas.stream()
            .filter(r -> !r.isCancelada() && r.getNumeroHabitacion() == numeroHabitacion)
            .noneMatch(r -> 
                (fechaCheckIn.isBefore(r.getFechaCheckOut()) || fechaCheckIn.isEqual(r.getFechaCheckOut())) &&
                (fechaCheckOut.isAfter(r.getFechaCheckIn()) || fechaCheckOut.isEqual(r.getFechaCheckIn()))
            );
    }

    /**
     * Cancela una reserva existente.
     * @param idReserva ID de la reserva a cancelar
     */
    public void cancelarReserva(int idReserva) {
        reservas.stream()
            .filter(r -> r.getId() == idReserva && !r.isCancelada())
            .findFirst()
            .ifPresent(r -> r.setCancelada(true));
    }

    /**
     * Obtiene la lista de reservas activas de un usuario.
     * @param idUsuario ID del usuario
     * @return Lista de reservas activas
     */
    public List<Reserva> getReservasActivas(int idUsuario) {
        return reservas.stream()
            .filter(r -> r.getIdUsuario() == idUsuario && !r.isCancelada())
            .collect(Collectors.toList());
    }

    /**
     * Obtiene el historial completo de reservas de un usuario.
     * @param idUsuario ID del usuario
     * @return Lista de reservas
     */
    public List<Reserva> getHistorialReservas(int idUsuario) {
        return reservas.stream()
            .filter(r -> r.getIdUsuario() == idUsuario)
            .collect(Collectors.toList());
    }

    /**
     * Muestra las reservas activas de un usuario.
     * @param idUsuario ID del usuario
     */
    public void mostrarReservasActivas(int idUsuario) {
        List<Reserva> activas = getReservasActivas(idUsuario);
        if (activas.isEmpty()) {
            System.out.println("No tiene reservas activas");
            return;
        }

        System.out.println("\nID | HABITACIÓN | CHECK-IN  | CHECK-OUT | PRECIO TOTAL");
        System.out.println("---+-----------+----------+-----------+-------------");
        activas.forEach(r -> System.out.printf("%-3d| %-10d| %-10s| %-10s| $%.2f%n",
            r.getId(), r.getNumeroHabitacion(), r.getFechaCheckIn(), r.getFechaCheckOut(), r.getPrecioTotal()));
    }

    /**
     * Muestra el historial completo de reservas de un usuario.
     * @param idUsuario ID del usuario
     */
    public void mostrarHistorialReservas(int idUsuario) {
        List<Reserva> historial = getHistorialReservas(idUsuario);
        if (historial.isEmpty()) {
            System.out.println("No tiene historial de reservas");
            return;
        }

        System.out.println("\nID | HABITACIÓN | CHECK-IN  | CHECK-OUT | PRECIO TOTAL | ESTADO");
        System.out.println("---+-----------+----------+-----------+-------------+--------");
        historial.forEach(r -> System.out.printf("%-3d| %-10d| %-10s| %-10s| $%-10.2f| %s%n",
            r.getId(), r.getNumeroHabitacion(), r.getFechaCheckIn(), r.getFechaCheckOut(), r.getPrecioTotal(),
            r.isCancelada() ? "Cancelada" : "Activa"));
    }
}