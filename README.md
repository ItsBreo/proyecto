# Gestor de Habitaciones de Hotel

## Descripción

Este es un proyecto en **Java** que implementa un **gestor de habitaciones de hotel** utilizando el **patrón de diseño MVC (Modelo-Vista-Controlador)**. Permite gestionar habitaciones, verificar su disponibilidad y realizar reservas.

## Tecnologías Utilizadas

- **Java 17+**
- **Patrón MVC**
- **Maven** para la gestión de dependencias

## Estructura del Proyecto

```
mi_proyecto_mvc/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── azael/josue/
│   │   │   │   ├── Main.java          # Punto de entrada de la aplicación
│   │   │   │   ├── modelo/            # Clases del modelo (Ej: Habitacion.java)
│   │   │   │   ├── vista/             # Clases de la vista (Ej: Interfaz.java)
│   │   │   │   ├── controlador/       # Clases del controlador (Ej: HabitacionController.java)
│   │   ├── resources/                 # Configuración y archivos adicionales
│   ├── test/                           # Pruebas unitarias
│── pom.xml                              # Archivo de configuración de Maven
```

## Clases Principales

### **Modelo** (`modelo`)

- `Habitacion.java`: Representa una habitación del hotel.
- `Reserva.java`: Representa una reserva de habitación.

### **Vista** (`vista`)

- `Interfaz.java`: Maneja la interfaz de usuario en consola.

### **Controlador** (`controlador`)

- `HabitacionController.java`: Controla la lógica de gestión de habitaciones.

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Puedes usarlo libremente para fines educativos o comerciales.

---

**Autores:** Azael y Josue 🚀

