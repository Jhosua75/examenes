import modelo.*;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Connection con = Conexion.obtenerConexion();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE PRODUCTOS, CLIENTES Y VENTAS =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Registrar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Listar clientes");
            System.out.println("6. Registrar venta");
            System.out.println("7. Listar ventas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> registrarEmpleado();
                case 3 -> registrarProducto();
                case 4 -> listarProductos();
                case 5 -> listarClientes();
                case 6 -> registrarVenta();
                case 7 -> listarVentas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        Conexion.cerrarConexion();
    }

    // ================= CLIENTE =================

    static void registrarCliente() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        if (!Validaciones.validarNombre(nombre) || !Validaciones.validarCorreo(correo)) {
            System.out.println("Nombre o correo no válidos. No se registró el cliente.");
            return;
        }

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(0, nombre, correo, direccion);

        String sql = "INSERT INTO dbo.Cliente (nombre, correo, direccion) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getDireccion());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        cliente.setId(rs.getInt(1));
                    }
                }
                System.out.println("Cliente registrado con id: " + cliente.getId());
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar el cliente.");
            e.printStackTrace();
        }
    }

    static ArrayList<Cliente> listarClientes() {

        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT idCliente, nombre, correo, direccion FROM dbo.Cliente";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n----- CLIENTES -----");
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("direccion")
                );
                clientes.add(c);
                System.out.println("[" + c.getId() + "] " + c.mostrarInformacion());
            }

        } catch (SQLException e) {
            System.out.println("Error al listar los clientes.");
            e.printStackTrace();
        }

        return clientes;
    }

    // ================= EMPLEADO =================

    static void registrarEmpleado() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        if (!Validaciones.validarNombre(nombre) || !Validaciones.validarCorreo(correo)) {
            System.out.println("Nombre o correo no válidos. No se registró el empleado.");
            return;
        }

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        Empleado empleado = new Empleado(0, nombre, correo, cargo);

        String sql = "INSERT INTO dbo.Empleado (nombre, correo, cargo) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getCorreo());
            ps.setString(3, empleado.getCargo());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        empleado.setId(rs.getInt(1));
                    }
                }
                System.out.println("Empleado registrado con id: " + empleado.getId());
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar el empleado.");
            e.printStackTrace();
        }
    }

    static ArrayList<Empleado> listarEmpleados() {

        ArrayList<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT idEmpleado, nombre, correo, cargo FROM dbo.Empleado";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n----- EMPLEADOS -----");
            while (rs.next()) {
                Empleado e = new Empleado(
                        rs.getInt("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("cargo")
                );
                empleados.add(e);
                System.out.println("[" + e.getId() + "] " + e.mostrarInformacion());
            }

        } catch (SQLException e) {
            System.out.println("Error al listar los empleados.");
            e.printStackTrace();
        }

        return empleados;
    }

    // ================= PRODUCTO =================

    static void registrarProducto() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Stock: ");
        int stock = Integer.parseInt(sc.nextLine());

        Producto producto = new Producto(0, nombre, precio, stock);

        String sql = "INSERT INTO dbo.Producto (nombre, precio, stock) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        producto.setId(rs.getInt(1));
                    }
                }
                System.out.println("Producto registrado con id: " + producto.getId());
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar el producto.");
            e.printStackTrace();
        }
    }

    static ArrayList<Producto> listarProductos() {

        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT idProducto, nombre, precio, stock FROM dbo.Producto";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n----- PRODUCTOS -----");
            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                productos.add(p);
                System.out.println("[" + p.getId() + "] " + p.getNombre()
                        + " | Precio: S/ " + p.getPrecio()
                        + " | Stock: " + p.getStock());
            }

        } catch (SQLException e) {
            System.out.println("Error al listar los productos.");
            e.printStackTrace();
        }

        return productos;
    }

    static boolean actualizarStock(int idProducto, int nuevoStock) {

        String sql = "UPDATE dbo.Producto SET stock = ? WHERE idProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock.");
            e.printStackTrace();
        }

        return false;
    }

    // ================= VENTA =================

    static void registrarVenta() {

        ArrayList<Cliente> clientes = listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados. Registra uno primero.");
            return;
        }

        System.out.print("Id del cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());

        Cliente clienteSeleccionado = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) clienteSeleccionado = c;
        }

        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        ArrayList<Empleado> empleados = listarEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados. Registra uno primero.");
            return;
        }

        System.out.print("Id del empleado: ");
        int idEmpleado = Integer.parseInt(sc.nextLine());

        Empleado empleadoSeleccionado = null;
        for (Empleado e : empleados) {
            if (e.getId() == idEmpleado) empleadoSeleccionado = e;
        }

        if (empleadoSeleccionado == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        Venta venta = new Venta(0, clienteSeleccionado, empleadoSeleccionado);

        ArrayList<Producto> productosDisponibles = listarProductos();
        if (productosDisponibles.isEmpty()) {
            System.out.println("No hay productos registrados. Registra uno primero.");
            return;
        }

        String agregarOtro = "S";
        do {
            System.out.print("Id del producto a vender: ");
            int idProducto = Integer.parseInt(sc.nextLine());

            Producto productoSeleccionado = null;
            for (Producto p : productosDisponibles) {
                if (p.getId() == idProducto) productoSeleccionado = p;
            }

            if (productoSeleccionado == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            if (!productoSeleccionado.hayStock(cantidad)) {
                System.out.println("Stock insuficiente. Stock disponible: " + productoSeleccionado.getStock());
                continue;
            }

            venta.agregarDetalle(new DetalleVenta(productoSeleccionado, cantidad));
            productoSeleccionado.reducirStock(cantidad);

            System.out.print("¿Agregar otro producto a la venta? (S/N): ");
            agregarOtro = sc.nextLine();

        } while (agregarOtro.equalsIgnoreCase("S"));

        if (venta.getDetalles().isEmpty()) {
            System.out.println("La venta no tiene productos. No se registró.");
            return;
        }

        System.out.println("Total de la venta (calculado en Java): S/ " + venta.calcularTotal());

        guardarVenta(venta);
    }

    static void guardarVenta(Venta venta) {

        String sqlVenta = "INSERT INTO dbo.Venta (fecha, idCliente, idEmpleado, total) VALUES (?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO dbo.DetalleVenta (idVenta, idProducto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";

        try {
            con.setAutoCommit(false);

            int idVentaGenerado;

            try (PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
                psVenta.setTimestamp(1, new Timestamp(venta.getFecha().getTime()));
                psVenta.setInt(2, venta.getCliente().getId());
                psVenta.setInt(3, venta.getEmpleado().getId());
                psVenta.setDouble(4, venta.calcularTotal());
                psVenta.executeUpdate();

                try (ResultSet rs = psVenta.getGeneratedKeys()) {
                    rs.next();
                    idVentaGenerado = rs.getInt(1);
                }
            }

            try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle)) {
                for (DetalleVenta detalle : venta.getDetalles()) {
                    psDetalle.setInt(1, idVentaGenerado);
                    psDetalle.setInt(2, detalle.getProducto().getId());
                    psDetalle.setInt(3, detalle.getCantidad());
                    psDetalle.setDouble(4, detalle.getPrecio());
                    psDetalle.setDouble(5, detalle.calcularSubtotal());
                    psDetalle.addBatch();
                }
                psDetalle.executeBatch();
            }

            con.commit();

            for (DetalleVenta detalle : venta.getDetalles()) {
                actualizarStock(detalle.getProducto().getId(), detalle.getProducto().getStock());
            }

            System.out.println("Venta registrada con id: " + idVentaGenerado);

        } catch (SQLException e) {
            System.out.println("Error al guardar la venta. Se revirtieron los cambios.");
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void listarVentas() {

        String sql = "SELECT v.idVenta, v.fecha, v.total, c.nombre AS cliente, e.nombre AS empleado " +
                "FROM dbo.Venta v " +
                "JOIN dbo.Cliente c ON v.idCliente = c.idCliente " +
                "JOIN dbo.Empleado e ON v.idEmpleado = e.idEmpleado " +
                "ORDER BY v.idVenta";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n----- VENTAS -----");
            while (rs.next()) {
                System.out.println("Venta #" + rs.getInt("idVenta")
                        + " | Fecha: " + rs.getTimestamp("fecha")
                        + " | Cliente: " + rs.getString("cliente")
                        + " | Empleado: " + rs.getString("empleado")
                        + " | Total: S/ " + rs.getDouble("total"));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las ventas.");
            e.printStackTrace();
        }
    }
}