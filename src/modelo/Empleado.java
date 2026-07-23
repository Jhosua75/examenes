package modelo;

public class Empleado extends Persona {

    private String cargo;

    public Empleado(int id, String nombre, String correo, String cargo) {
        super(id, nombre, correo);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String mostrarInformacion() {
        return "Empleado: " + getNombre()
                + " | Correo: " + getCorreo()
                + " | Cargo: " + cargo;
    }
}