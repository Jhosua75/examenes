package com.lideratec.academy;

public class UtilEscolar extends Producto implements Descuento {

    private String marca;

    public UtilEscolar(String codigo, String nombre, double precio, String marca) {
        super(codigo, nombre, precio);
        this.marca = marca;
    }

    @Override
    public double calcularDescuento() {
        return precio * 0.05;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("---- ÚTIL ESCOLAR ----");
        System.out.println("Código : " + codigo);
        System.out.println("Nombre : " + nombre);
        System.out.println("Marca  : " + marca);
        System.out.println("Precio : S/" + precio);
        System.out.println("Descuento : S/" + calcularDescuento());
        System.out.println("-------------------------");
    }

}