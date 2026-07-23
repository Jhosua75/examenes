import modelo.Producto;

public class Validaciones {

    public static boolean validarNombre(String nombre) {

        return nombre != null
                && !nombre.trim().isEmpty()
                && nombre.length() >= 3;
    }

    public static boolean validarCorreo(String correo) {

        return correo.contains("@")
                && correo.contains(".");
    }

    public static double calcularPrecioConDescuento(
            double precio,
            double porcentaje
    ) {

        double descuento = precio * (porcentaje / 100);

        return Math.round((precio - descuento) * 100.0)
                / 100.0;
    }

    public static void main(String[] args) {

        String nombre = "Laptop";

        String correo = "cliente@gmail.com";

        double precio = 2500;

        double precioFinal =
                calcularPrecioConDescuento(precio, 10);

        System.out.println("===== VALIDACIONES =====");

        System.out.println(
                "Nombre válido: "
                        + validarNombre(nombre)
        );

        System.out.println(
                "Correo válido: "
                        + validarCorreo(correo)
        );

        System.out.println(
                "Precio original: S/ "
                        + precio
        );

        System.out.println(
                "Precio con descuento: S/ "
                        + precioFinal
        );
    }
}