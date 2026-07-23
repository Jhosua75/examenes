package modelo;

public class Cliente extends Persona {

    private String direccion;

    public Cliente(int id, String nombre, String correo, String direccion) {
        super(id, nombre, correo);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String mostrarInformacion() {
        return "Cliente: " + getNombre()
                + " | Correo: " + getCorreo()
                + " | Dirección: " + direccion;
    }
}