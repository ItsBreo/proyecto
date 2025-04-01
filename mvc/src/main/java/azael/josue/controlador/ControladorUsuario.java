package azael.josue.controlador;

import java.util.ArrayList;
import java.util.List;

import azael.josue.Modelo.Reserva;
import azael.josue.Modelo.Usuario;

public class ControladorUsuario {
    private List<Usuario> usuarios;
    private static int nextId = 1;
    
    public ControladorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario registrarUsuario(String nombre, String contraseña) {
        // Verificamos si ya existe un usuario con ese nombre y contraseña
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                if (usuario.getContraseña().equals(contraseña)) {
                    System.out.println("\n Ya estás registrad@, " + nombre + ", por favor, inicia sesión.");
                    return usuario; // Devolvemos el usuario existente
                } else {
                    System.out.println("\nYa existe un usuario con ese nombre. Por favor, use otro nombre.");
                    return null;
                }
            }
        }

        // Si no existe, crear nuevo usuario con ID autogenerado
        Usuario nuevoUsuario = new Usuario(nombre, nextId++, contraseña);
        usuarios.add(nuevoUsuario);
        System.out.println("\n¡Registro exitoso!");
        System.out.println("Su ID de usuario es: " + nuevoUsuario.getId());
        return nuevoUsuario;
    }

    public Usuario iniciarSesion(String nombre, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                System.out.println("\nBienvenido " + nombre + "!");
                return usuario;
            }
        }
        System.out.println("\nCredenciales incorrectas");
        return null;
    }   

    public void mostrarInformacionCliente(Usuario usuario) {
        if (usuario != null) {
            System.out.println("\n=== Información del Cliente ===");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("ID: " + usuario.getId());
            System.out.print("Reserva Actual: ");
            if (usuario.getIdReserva() == null) {
                System.out.println("Sin reserva actual");
            } else {
                System.out.println(usuario.getIdReserva());
            }
            System.out.println("\nHistorial de Reservas:");
            ArrayList<Reserva> historial = usuario.getHistorialReservas();
            if (historial != null && !historial.isEmpty()) {
                for (Reserva reserva : historial) {
                    System.out.println("- " + reserva.toString());
                }
            } else {
                System.out.println("No hay reservas en el historial");
            }
            System.out.println("==============================\n");
        } else {
            System.out.println("No se ha encontrado información del cliente");
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
