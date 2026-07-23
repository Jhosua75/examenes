# Sistema de Ventas — Evaluación Integral Final (POO)

Aplicación de consola en Java que gestiona clientes, empleados, productos y
ventas, aplicando programación orientada a objetos y persistencia de datos
con JDBC sobre SQL Server.

## Datos del curso

| Campo | Detalle |
|---|---|
| Institución | ISIL |
| Curso | Programación Orientada a Objetos |
| Código | 6756 |
| Docente(s) | Wilder Julio Espinoza Bravo |
| Sección | 6756 |
| Fecha | 22 de julio de 2026 |

## Propósito

Sistema académico que permite registrar clientes, empleados y productos, y
generar ventas asociando productos con control de stock. Toda la
información se guarda en una base de datos SQL Server mediante JDBC, por lo
que los datos persisten entre ejecuciones.

## Integrantes del equipo

- Jose Carlos Diaz Rojas
- Mateo Bohorquez Surichaqui
- Angel Cuba Blacido
- Jhosua David Huaman Chate
- Ayrton Mihail Palomino Loli

## Tecnologías utilizadas

- Java
- JDBC con driver de Microsoft SQL Server (`mssql-jdbc`)
- Microsoft SQL Server (base de datos `SistemaVentas`)
- IntelliJ IDEA

## Estructura del proyecto

```
SistemaVentas_EP_POO/
├── script_base_datos.sql      # Script de creación de la base de datos y tablas
├── src/
│   ├── Main.java               # Menú principal (Scanner + estructuras de control)
│   ├── Validaciones.java       # Validaciones con String y cálculo con Math
│   ├── conexion/
│   │   └── Conexion.java       # Conexión JDBC a SQL Server
│   └── modelo/                 # Clases del dominio (herencia, encapsulamiento, polimorfismo)
│       ├── Persona.java        # Clase abstracta
│       ├── Cliente.java        # Hereda de Persona
│       ├── Empleado.java       # Hereda de Persona
│       ├── Producto.java
│       ├── DetalleVenta.java
│       └── Venta.java
```

## Cómo ejecutar el proyecto

### 1. Preparar la base de datos

1. Instalar SQL Server (o usar una instancia existente) junto con SQL Server
   Management Studio (SSMS).
2. Crear la base de datos `SistemaVentas`.
3. Crear un usuario de SQL Server con permisos sobre esa base (por defecto
   el proyecto usa el usuario `appuser`; puede cambiarse en `Conexion.java`).
4. Ejecutar el script `script_base_datos.sql` en SSMS para crear las tablas
   `Cliente`, `Empleado`, `Producto`, `Venta` y `DetalleVenta`.

### 2. Configurar la conexión

En `src/conexion/Conexion.java`, ajustar si es necesario:
- `INSTANCIA` y `PUERTO` (por defecto `localhost:1433`)
- `USUARIO` y `CONTRASENA` (deben coincidir con el usuario creado en SSMS)

### 3. Agregar el driver JDBC de SQL Server

Descargar el driver `mssql-jdbc` (Microsoft JDBC Driver for SQL Server) y
agregarlo como librería del proyecto en IntelliJ:
`File > Project Structure > Libraries > + > Java`, seleccionando el `.jar`
descargado.

### 4. Ejecutar

Correr la clase `Main.java` (click derecho → Run 'Main.main()').

## Funcionalidades

- Registro de clientes, empleados y productos, con validaciones de nombre
  y correo (`Validaciones.java`, usando `String` y `Math`).
- Listado de clientes, empleados y productos desde la base de datos.
- Registro de ventas con múltiples productos, validando stock disponible
  antes de vender.
- Cálculo del total de la venta en Java y guardado de la venta junto con su
  detalle en una sola transacción (con `rollback` si algo falla).
- Actualización automática del stock en la base de datos tras cada venta.
- Listado de ventas con datos de cliente y empleado (mediante `JOIN`).
- Persistencia completa en SQL Server vía JDBC.

## Video de exposición

Enlace al video en YouTube: **[pegar aquí el enlace]**

## Repositorio

Enlace al repositorio en GitHub: **[pegar aquí el enlace]**
