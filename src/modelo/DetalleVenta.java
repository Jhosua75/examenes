package modelo;

public class DetalleVenta {

    private Producto producto;
    private int cantidad;
    private double precio;

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = producto.getPrecio();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double calcularSubtotal() {
        return precio * cantidad;
    }
}