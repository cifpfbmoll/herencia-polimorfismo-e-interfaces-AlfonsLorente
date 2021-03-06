import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Bibliotecario extends Persona {
    //ATRIBUTOS
    private String puestoTrabajo;
    private String nif;
    private String contraseña;

    //CONSTRUCTORES
    public Bibliotecario() {

    }

    public Bibliotecario(String nombre, String apellido1, String apellido2, int edad, String puestoTrabajo, String nif, String contraseña) {
        super(nombre, apellido1, apellido2, edad);
        this.setPuestoTrabajo(puestoTrabajo);
        this.setNif(nif);
        this.setContraseña(contraseña);
    }

    public Bibliotecario(Bibliotecario bibliotecario) {
        super((Persona) bibliotecario);
        this.setPuestoTrabajo(bibliotecario.getPuestoTrabajo());
        this.setNif(bibliotecario.getNif());
        this.setContraseña(bibliotecario.getContraseña());
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    //GETTERS Y SETTERS
    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "puestoTrabajo='" + puestoTrabajo + '\'' +
                ", nif='" + nif + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    //Solicitar los datos de un Bibliotecario i por tanto crear uno
    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona();
        System.out.print("Puesto de trabajo: ");
        this.setPuestoTrabajo(scanner.nextLine());
        System.out.print("NIF: ");
        this.setNif(scanner.nextLine());
        System.out.print("Constraseña: ");
        this.setContraseña(scanner.nextLine());
    }



    //Funcion para identificar a un bibliotecario
    public static void identificarse(ArrayList<Persona> personas) {
        boolean acierto = false;
        while (acierto != true) {
            //Pedir datos
            System.out.print("Nif: ");
            String pruebaNif = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pruebaContrasenya = scanner.nextLine();
            //Loopear por la lista de personas
            for(int i = 0; i < personas.size(); i++){
                //Encontrar los bibliotecarios
                if(personas.get(i) instanceof Bibliotecario){
                    //Ver si los datos coinciden
                    if(((Bibliotecario)personas.get(i)).getNif().equals(pruebaNif) && ((Bibliotecario)personas.get(i)).getContraseña().equals(pruebaContrasenya)){
                        acierto = true;
                    }
                    else{
                        System.out.println("ERROR DE AUTENTIFICACION, NIF O CONTRASEÑA INCORRECTA");
                    }

                }
            }

        }

    }



    private static Usuario comprobarUsuario(ArrayList<Persona> personas){
        //pedir datos del usuario
        System.out.print("Telefono del usuario: ");
        int telefono = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Correo electronico del usuario: ");
        String correo = scanner.nextLine();
        //Comprobar usuario
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i) instanceof Usuario) {
                if (((Usuario)personas.get(i)).getTelefono() == telefono && ((Usuario)personas.get(i)).getCorreoElectronico().equals(correo)) {
                    System.out.println("Usuario correcto");
                    return ((Usuario)personas.get(i));
                }
            }
        }
        System.out.println("Usuario incorrecto");
        return null;
    }


    public static Reserva reservarLibro(ArrayList<Persona> personas, ArrayList<Libro> libros) {
        //Crear reserva
        Reserva reserva = new Reserva();
            //pedir datos del usuario
            Usuario usuario = comprobarUsuario(personas);
            if(usuario != null){
                //Pedir ISBN
                System.out.print("ISBN del libro a reservar: ");
                int isbn = scanner.nextInt();
                scanner.nextLine();
                //Comprobar si existe el libro
                for (int i = 0; i < libros.size(); i++) {
                    if (libros.get(i).getIsbn() == isbn) {
                        //Comprobar si esta disponible
                        if (libros.get(i).getNumCopiasDisponibles() == 0) {
                            System.out.println("No hay copias disponibles del libro");
                        } else {
                            //Hacer la reserva
                            System.out.println("Hay un total de: " + libros.get(i).getNumCopiasDisponibles() + " libros disponibles");
                            reserva.hacerReserva(libros.get(i), isbn, usuario);
                        }
                    }
                }
            }else {
                System.out.println("NO SE HA ENCONTRADO EL USUARIO");
            }


        //LA RESERVA PUEDE DEVOLVERSE VACIA, LUEGO SE DEBE COMPROBAR SI ESTA VACIA O NO.
        return reserva;
    }

    public static ArrayList<Reserva> devolverLibro(ArrayList<Persona> personas, ArrayList<Libro> libros, ArrayList <Reserva> reservas) {
        //pedir datos del usuario
        Usuario usuario = comprobarUsuario(personas);
        if(usuario != null){
            //Pedir ISBN
            System.out.print("ISBN del libro a reservar: ");
            int isbn = scanner.nextInt();
            scanner.nextLine();
            //Comprobar si existe una reserva con ese ISBN i con un usuario que lo haya reservado
            for (int i = 0; i < reservas.size(); i++) {
                //Comprobar si hay alguna reserva con el libro y ver si el usuario es el mismo que hizo esa reserva
                if ((reservas.get(i).getLibro().getIsbn() == isbn) && (usuario.getCorreoElectronico().equals(reservas.get(i).getUsuario().getCorreoElectronico()))) {
                    System.out.println("Se ha encontrado la reserva, se va a proceder a la devolucion");
                    for(int j = 0; j < libros.size(); j++){
                        if(reservas.get(i).getLibro().getIsbn() == libros.get(j).getIsbn()){
                            //Modificar la cantidad de copias disponibles del libro
                            libros.get(j).setNumCopiasDisponibles(libros.get(j).getNumCopiasDisponibles() + reservas.get(i).getCantidadReservada());
                            reservas.remove(i);//Quitar la reserva
                        }
                    }
                }
            }
        }else {
            System.out.println("NO SE HA ENCONTRADO EL USUARIO");
        }

        return reservas;
    }




    //Override obligatorio del metodo cambiarContraseña
    @Override
    public boolean cambiarContraseña(String usuario, String contraseña){
        //Mirar si el usario coincide con el Nif
        if(this.getNif().equals(usuario)){
            //Cambiar contraseña
            this.setContraseña(contraseña);
            System.out.println("Se ha cambiado la contraseña");
            return true;
        }
        return false;
    }

}