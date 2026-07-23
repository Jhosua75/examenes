package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String INSTANCIA = "localhost";
    private static final String PUERTO = "1433";
    private static final String BASE_DATOS = "SistemaVentas";

    // Cambia estos dos valores por el usuario y contraseña que creaste en SSMS
    private static final String USUARIO = "appuser";
    private static final String CONTRASENA = "Poo2026*";

    // Cadena de conexión por TCP/IP con autenticación de SQL Server
    private static final String URL =
            "jdbc:sqlserver://" + INSTANCIA + ":" + PUERTO + ";"
                    + "databaseName=" + BASE_DATOS + ";"
                    + "user=" + USUARIO + ";"
                    + "password=" + CONTRASENA + ";"
                    + "encrypt=false;"
                    + "trustServerCertificate=true;";

    private static Connection conexion;

    private Conexion() {
    }

    public static Connection obtenerConexion() {

        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL);
                System.out.println("Conexión establecida con la base de datos: " + BASE_DATOS);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver JDBC de SQL Server.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }

        return conexion;
    }

    public static void cerrarConexion() {

        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con = obtenerConexion();

        if (con != null) {
            System.out.println("¡La conexión funciona correctamente!");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }

        cerrarConexion();
    }
}