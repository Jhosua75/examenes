package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Venta {

    private int id;
    private Date fecha;
    private Cliente cliente;
    private Empleado empleado;
    private ArrayList<DetalleVenta> detalles;

    public Venta(int id, Cliente cliente, Empleado empleado) {
        this.id = id;
        this.fecha = new Date();
        this.cliente = cliente;
        this.empleado = empleado;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;

        for (DetalleVenta detalle : detalles) {
            total += detalle.calcularSubtotal();
        }

        return total;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }
}