package app;


public class Equipo {
    String nombre;
    String tipo;
    boolean disponible;

    static int totalEquipos = 0;

    public Equipo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponible = true;
        totalEquipos++;
    }

    public void mostrarDatos() {
        System.out.println("Equipo: " + nombre + " - Tipo: " + tipo + " - Disponible: " + disponible);
    }
}