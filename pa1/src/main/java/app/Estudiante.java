package app;

public class Estudiante {
    String nombre;
    String codigo;

    static int totalEstudiantes = 0;

    public Estudiante(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        totalEstudiantes++;
    }

    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + " - Código: " + codigo);
    }
}