package com.lideratec.academy;

public class Libro extends Producto implements Descuento {

    private String autor;

    public Libro(String codigo, String nombre, double precio, String autor) {
        super(codigo, nombre, precio);
        this.autor = autor;
    }

    @Override
    public double calcularDescuento() {
        return precio * 0.10;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("----- LIBRO -----");
        System.out.println("Código : " + codigo);
        System.out.println("Nombre : " + nombre);
        System.out.println("Autor  : " + autor);
        System.out.println("Precio : S/" + precio);
        System.out.println("Descuento : S/" + calcularDescuento());
        System.out.println("-------------------------");
    }

}