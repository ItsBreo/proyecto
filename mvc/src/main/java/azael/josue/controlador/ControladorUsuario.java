package azael.josue.controlador;

import java.util.ArrayList;
import java.util.List;
import azael.josue.Modelo.Usuario;
import azael.josue.excepciones.ClienteNoEncontradoException;

/**
 * Controlador que maneja la lógica de los usuarios del hotel.
 * Se encarga de registrar usuarios y mostrar su información.
 */
public class ControladorUsuario {
    private List<Usuario> usuarios;
    private final ControladorReservas controladorReservas;
    private int nextId = 1;

    /**
     * Constructor que inicializa la lista de usuarios y recibe el controlador de reservas.
     * @param controladorReservas Controlador para gestionar las reservas
     */
    public ControladorUsuario(ControladorReservas controladorReservas) {
        this.usuarios = new ArrayList<>();
        this.controladorReservas = controladorReservas;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuario
     * @return El usuario creado
     */
    public Usuario registrarUsuario(String nombre, String password) {
        if (nombre == null || nombre.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y la contraseña no pueden estar vacíos");
        }

        Usuario usuario = new Usuario(nextId++, nombre, password);
        usuarios.add(usuario);
        return usuario;
    }

    /**
     * Muestra toda la información de un cliente, incluyendo sus reservas.
     * @param id ID del usuario
     * @throws ClienteNoEncontradoException si el usuario no existe
     */
    public void mostrarInformacionCliente(int id) throws ClienteNoEncontradoException {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario == null) {
            throw new ClienteNoEncontradoException("No se encontró el usuario con ID: " + id);
        }

        System.out.println("\n=== INFORMACIÓN DEL CLIENTE ===");
        System.out.println("ID: " + usuario.getId());
        
        // Mostrar reservas activas
        controladorReservas.mostrarReservasActivas(id);
        
        // Mostrar historial de reservas
        controladorReservas.mostrarHistorialReservas(id);
        System.out.println("==============================\n");
    }

    /**
     * Busca un usuario por su ID.
     * @param id ID del usuario a buscar
     * @return El usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.stream()
            .filter(u -> u.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
