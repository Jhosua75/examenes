package com.lideratec.academy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class TiendaAcademia {

    private ArrayList<Producto> productos;
    private HashSet<String> codigos;

    public TiendaAcademia() {
        productos = new ArrayList<>();
        codigos = new HashSet<>();
    }

    public boolean agregarProducto(Producto p) {

        if (codigos.contains(p.getCodigo())) {
            return false;
        }

        productos.add(p);
        codigos.add(p.getCodigo());

        return true;
    }

    public void listarProductos() {

        if (productos.isEmpty()) {
            System.out.println("No existen productos.");
            return;
        }

        for (Producto p : productos) {
            p.mostrarInformacion();
        }

    }

    public Producto buscarPorCodigo(String codigo) {

        for (Producto p : productos) {

            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }

        }

        return null;
    }

    public void buscarPorNombre(String nombre) {

        boolean encontrado = false;

        for (Producto p : productos) {

            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {

                p.mostrarInformacion();
                encontrado = true;

            }

        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

    }

    public void ordenarPorNombre() {

        Collections.sort(productos, new Comparator<Producto>() {

            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }

        });

        System.out.println("Productos ordenados correctamente.");

    }

}