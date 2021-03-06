import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Reserva implements Material {
    //ATRIBUTOS
    private static Scanner scanner = new Scanner(System.in);
    private Libro libro;
    private LocalDate fecha;
    private LocalTime hora;
    private int cantidadReservada;
    private Usuario usuario;

    //CONSTRUCTORES
    public Reserva() {
    }

    public Reserva(Libro libro, LocalDate fecha, LocalTime hora, int cantidadReservada, Usuario usuario) {
        this.setLibro(libro);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setCantidadReservada(cantidadReservada);
        this.setUsuario(usuario);
    }
    public Reserva(Reserva reserva) {
        this.setLibro(reserva.getLibro());
        this.setFecha(reserva.getFecha());
        this.setHora(reserva.getHora());
        this.setCantidadReservada(reserva.getCantidadReservada());
        this.setUsuario(reserva.getUsuario());
    }
    //TOSTRING


    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", cantidadReservada=" + cantidadReservada +
                ", usuario=" + usuario +
                '}';
    }

    //GETTERS Y SETTERS
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCantidadReservada() {
        return cantidadReservada;
    }

    public void setCantidadReservada(int cantidadReservada) {
        this.cantidadReservada = cantidadReservada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //Hacer reservas de libros
    public void hacerReserva(Libro libro, int isbn, Usuario usuario){
        System.out.println("Cuantos quieres reservar? ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        //Reservar la cantidad de libros deseada
        if(libro.getIsbn() == isbn){
            while((libro.getNumCopiasDisponibles() - cantidad) < 0){
                System.out.println("No hay tantas copias disponibles, pon menos cantidad: ");
                cantidad = scanner.nextInt();
                scanner.nextLine();

            }
            libro.setNumCopiasDisponibles(libro.getNumCopiasDisponibles() - cantidad);
            //Ponemos los datos de la reserva
            this.setLibro(libro);
            this.setFecha(LocalDate.now());
            this.setHora(LocalTime.now());
            this.setCantidadReservada(cantidad);
            this.setUsuario(usuario);
        }
    }

    //Obtener la fecha de la devolucion
    @Override
    public LocalDate obtenerFechaDevolucion() {
        return this.getFecha().plusDays(30);//Devuelve 30 dias despues

    }

    public Reserva encontrarReserva(ArrayList<Reserva> reservas){
        System.out.print("Introduce el correo electronico del usuario de la reserva: ");
        String Correo = scanner.nextLine();
        System.out.print("Introduce el titulo del libro reservado");
        String titulo = scanner.nextLine();
        for(int i = 0; i < reservas.size(); i++){
            if(reservas.get(i).getUsuario().getCorreoElectronico().equals(Correo) && reservas.get(i).getLibro().getTitulo().equals(titulo)){
                return reservas.get(i);
            }
        }
        return null;
    }
    //Mostrar la informacion mas bonita que en el toString

    @Override
    public void mostrarInfoChula() {
        System.out.println("INFORMACION SOBRE LA RESERVA: ");
        System.out.println("Libro reservado: ");
        System.out.println("\t ISBN: " + this.getLibro().getIsbn());
        System.out.println("\t Autor: " + this.getLibro().getAutor());
        System.out.println("\t Editorial: " + this.getLibro().getEditorial());
        System.out.println("\t Cantidad reservada: " + this.getCantidadReservada());
        System.out.println("Tiempo de la reserva: ");
        System.out.println("\t Fecha: " + this.getFecha());
        System.out.println("\t Hora: " + this.getHora());
        System.out.println("Persona que ha reservado la reserva: ");
        System.out.println("\t Nombre: " + this.getUsuario().getNombre());
        System.out.println("\t Apellidos: " + this.getUsuario().getApellido1() + " " + getUsuario().getApellido2());
        System.out.println("\t Telefono: " + this.getUsuario().getTelefono());
        System.out.println("\t Correo electronico: " + this.getUsuario().getCorreoElectronico());

    }
}
