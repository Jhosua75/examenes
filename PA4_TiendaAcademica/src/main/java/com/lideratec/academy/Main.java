package com.lideratec.academy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TiendaAcademia tienda = new TiendaAcademia();

        int opcion;

        do {

            System.out.println("\n====== TIENDA ACADÉMIA ======");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Útil Escolar");
            System.out.println("3. Listar Productos");
            System.out.println("4. Buscar por Código");
            System.out.println("5. Buscar por Nombre");
            System.out.println("6. Ordenar por Nombre");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Código: ");
                    String codigoL = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreL = sc.nextLine();

                    System.out.print("Precio: ");
                    double precioL = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    Libro libro = new Libro(codigoL, nombreL, precioL, autor);

                    if (tienda.agregarProducto(libro)) {
                        System.out.println("Libro registrado correctamente.");
                    } else {
                        System.out.println("El código ya existe.");
                    }

                    break;

                case 2:

                    System.out.print("Código: ");
                    String codigoU = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombreU = sc.nextLine();

                    System.out.print("Precio: ");
                    double precioU = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    UtilEscolar util = new UtilEscolar(codigoU, nombreU, precioU, marca);

                    if (tienda.agregarProducto(util)) {
                        System.out.println("Útil escolar registrado correctamente.");
                    } else {
                        System.out.println("El código ya existe.");
                    }

                    break;

                case 3:

                    tienda.listarProductos();
                    break;

                case 4:

                    System.out.print("Ingrese código: ");
                    String codigoBuscar = sc.nextLine();

                    Producto p = tienda.buscarPorCodigo(codigoBuscar);

                    if (p != null) {
                        p.mostrarInformacion();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("Ingrese nombre: ");
                    String nombreBuscar = sc.nextLine();

                    tienda.buscarPorNombre(nombreBuscar);

                    break;

                case 6:

                    tienda.ordenarPorNombre();
                    tienda.listarProductos();

                    break;

                case 7:

                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 7);

        sc.close();

    }

}