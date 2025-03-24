package azael.josue.Modelo;

public class Habitacion {
    private int numero;
    private String tipo; // "Individual", "Doble" o "Suite"
    private String estado; // "Disponible" o "Reservada"

    // Constructor con sus características de habitacion
    public Habitacion(int numero, String tipo, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Mostrar en String información de la habtación
    @Override
    public String toString() {
        return "Habitación " + numero + " - " + tipo + " - Estado: " + estado;
    }
}
