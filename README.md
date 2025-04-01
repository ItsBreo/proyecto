# Sistema de Gestión Hotelera

## 📋 Descripción
Sistema de gestión hotelera desarrollado en Java que permite administrar habitaciones, reservas y clientes. Implementa el patrón de diseño MVC (Modelo-Vista-Controlador) para una mejor organización y mantenibilidad del código.

## ✨ Características Principales
- Gestión de habitaciones (individuales, dobles y suites)
- Sistema de reservas con validación de fechas
- Administración de clientes
- Visualización de disponibilidad en tiempo real
- Historial de reservas por cliente

## 🛠️ Tecnologías
- Java 17+
- Maven para gestión de dependencias
- Arquitectura MVC
- Streams y programación funcional
- JavaDoc para documentación

## 📁 Estructura del Proyecto
```
proyecto/
├── src/main/java/azael/josue/
│   ├── Main.java                    # Punto de entrada
│   ├── controlador/
│   │   ├── ControladorHabitaciones  # Gestión de habitaciones
│   │   ├── ControladorReservas      # Gestión de reservas
│   │   └── ControladorUsuario       # Gestión de usuarios
│   ├── modelo/
│   │   ├── Habitacion              # Modelo de habitación
│   │   ├── Reserva                 # Modelo de reserva
│   │   ├── Usuario                 # Modelo de usuario
│   │   ├── TipoHabitacion         # Tipos de habitaciones
│   │   └── EstadoHabitacion       # Estados posibles
│   └── vista/
│       ├── MenuPrincipal          # Menú principal
│       ├── VistaHabitaciones      # Vista de habitaciones
│       ├── VistaReservas          # Vista de reservas
│       └── VistaCliente           # Vista de clientes
```

## 🚀 Funcionalidades
1. **Gestión de Habitaciones**
   - Ver todas las habitaciones
   - Consultar disponibilidad
   - Ver precios por tipo

2. **Gestión de Reservas**
   - Crear nueva reserva
   - Cancelar reserva existente
   - Ver reservas activas

3. **Gestión de Clientes**
   - Ver información del cliente
   - Consultar historial de reservas

## 💻 Uso
1. Ejecutar la clase `Main.java`
2. Navegar por el menú principal usando las opciones numeradas
3. Seguir las instrucciones en pantalla para cada operación

## 📝 Documentación
Todo el código está documentado usando JavaDoc. Para ver la documentación detallada de cada clase y método, consultar los comentarios en el código fuente.