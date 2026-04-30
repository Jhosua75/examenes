package app;

public class Prestamo {
    Estudiante estudiante;
    Equipo equipo;
    int diasRetraso;

    public Prestamo(Estudiante estudiante, Equipo equipo, int diasRetraso) {
        this.estudiante = estudiante;
        this.equipo = equipo;
        this.diasRetraso = diasRetraso;
    }

    public double calcularPenalidad() {
        return diasRetraso * 2.5;
    }

    public void mostrarPrestamo() {
        estudiante.mostrarDatos();
        equipo.mostrarDatos();
        System.out.println("Días de retraso: " + diasRetraso);
        System.out.println("Penalidad: " + calcularPenalidad());
    }
}