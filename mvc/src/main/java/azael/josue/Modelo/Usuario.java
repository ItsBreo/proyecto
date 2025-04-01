package azael.josue.Modelo;

/**
 * Modelo que representa un usuario del sistema.
 * Almacena la información básica del usuario como su ID, nombre y contraseña.
 */
public class Usuario {
    private int id;
    private String nombre;
    private String password;

    /**
     * Constructor que crea un nuevo usuario.
     * @param id ID único del usuario
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuario
     */
    public Usuario(int id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    /**
     * Obtiene el ID del usuario.
     * @return ID del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("Usuario %d - %s", id, nombre);
    }
}