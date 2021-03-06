import java.time.temporal.Temporal;
import java.util.ArrayList;

public class Usuario extends Persona{

    //Atributos
    private int telefono;
    private String direccion;
    private int codigoPostal;
    private String correoElectronico;
    private ArrayList<Reserva> reservas = new ArrayList();

    //CONSTRUCTORES
    public Usuario(){
    }


    public Usuario(String nombre, String apellido1, String apellido2, int edad, int telefono, String direccion, int codigoPostal, String correoElectronico, ArrayList<Reserva> reservas) {
        super(nombre, apellido1, apellido2, edad);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCodigoPostal(codigoPostal);
        this.setCorreoElectronico(correoElectronico);
        this.setReservas(reservas);
    }

    public Usuario(Usuario usuario) {
        super((Persona)usuario);
        this.setTelefono(usuario.getTelefono());
        this.setDireccion(usuario.getDireccion());
        this.setCodigoPostal(usuario.getCodigoPostal());
        this.setCorreoElectronico(usuario.getCorreoElectronico());
        this.setReservas(usuario.getReservas());
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", reservas=" + reservas +
                "}" + "\n" +
                "Persona{" +
                "nombre=" + getNombre() +
                ", apellido1=" + getApellido1() +
                ", apellido2=" + getApellido2() +
                ", edad" + getEdad() +
                "}";
    }


    //Solicitar los datos de un usuario i por tanto crear uno

    @Override
    public void solicitarDatosPersona() {
        //Pedir datos de la persona i añadirlas a la persona
        super.solicitarDatosPersona();
        System.out.print("Telefono: ");
        this.setTelefono(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Direccion: ");
        this.setDireccion(scanner.nextLine());
        System.out.print("Codigo postal: ");
        this.setCodigoPostal(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Correo Electronico: ");
        this.setCorreoElectronico(scanner.nextLine());
        this.setReservas(this.getReservas());
    }

    @Override
    public boolean cambiarContraseña(String usuario, String contraseña){
        Integer numero = Integer.valueOf(usuario);
        //Mirar si el usario coincide con el Nif
        if(this.getTelefono() == numero){
            //Cambiar contraseña
            this.setCorreoElectronico(contraseña);
            System.out.println("Se ha cambiado la contraseña");
            return true;
        }
        return false;
    }
}
