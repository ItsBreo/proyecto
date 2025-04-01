package azael.josue.vista;

import java.util.Scanner;
import azael.josue.Modelo.Usuario;
import azael.josue.controlador.ControladorUsuario;

public class VistaCliente {
    private Scanner sc;
    private ControladorUsuario controlador;
    private Usuario usuarioActual;
    
    public VistaCliente(ControladorUsuario controlador, Scanner sc) {
        this.controlador = controlador;
        this.sc = sc;
        this.usuarioActual = null;
    }

    public void mostrarMenuCliente() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n=== MENÚ CLIENTE ===");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Ver información de cliente");
                System.out.println("0. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        registrarNuevoUsuario();
                        break;
                    case 2:
                        iniciarSesion();
                        break;
                    case 3:
                        if (usuarioActual != null) {
                            controlador.mostrarInformacionCliente(usuarioActual);
                        } else {
                            System.out.println("\nError: Primero debe iniciar sesión");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("\nError: Opción no válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: Por favor, ingrese un número válido");
                sc.nextLine(); // Limpiar el buffer
                opcion = -1;
            }
        } while (opcion != 0);
    }

    private void registrarNuevoUsuario() {
        System.out.println("\n=== REGISTRO/INICIO DE SESIÓN ===");
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese su contraseña: ");
        String contraseña = sc.nextLine();
        
        Usuario usuario = controlador.registrarUsuario(nombre, contraseña);
        if (usuario != null) {
            usuarioActual = usuario;
        }
    }

    private void iniciarSesion() {
        System.out.println("\n=== INICIO DE SESIÓN ===");
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese su contraseña: ");
        String contraseña = sc.nextLine();
        
        Usuario usuario = controlador.iniciarSesion(nombre, contraseña);
        if (usuario != null) {
            usuarioActual = usuario;
        }
    }   
}
