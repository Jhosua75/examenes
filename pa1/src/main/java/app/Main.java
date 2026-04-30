package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        int totalPrestamos = 0;
        int prestamosConRetraso = 0;
        double totalPenalidades = 0;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre estudiante: ");
                    String nombre = sc.nextLine();

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();

                    Estudiante est = new Estudiante(nombre, codigo);

                    System.out.print("Nombre equipo: ");
                    String nomEquipo = sc.nextLine();

                    System.out.print("Tipo equipo: ");
                    String tipo = sc.nextLine();

                    Equipo eq = new Equipo(nomEquipo, tipo);

                    if (eq.disponible) {
                        System.out.print("Días de retraso: ");
                        int dias = sc.nextInt();

                        Prestamo p = new Prestamo(est, eq, dias);

                        p.mostrarPrestamo();

                        eq.disponible = false;

                        totalPrestamos++;

                        if (dias > 0) {
                            prestamosConRetraso++;
                            totalPenalidades += p.calcularPenalidad();
                        }

                    } else {
                        System.out.println("Equipo no disponible");
                    }
                    break;

                case 2:
                    System.out.println("\n--- RESUMEN ---");
                    System.out.println("Total préstamos: " + totalPrestamos);
                    System.out.println("Con retraso: " + prestamosConRetraso);
                    System.out.println("Total penalidades: " + totalPenalidades);
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 2);

        sc.close();
    }
}