import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    //SCANNER
    public static Scanner scanner = new Scanner(System.in);
    public static Biblioteca biblioteca = new Biblioteca();

    //MAIN
    public static void main(String[] args) {

        //Crear una biblioteca
        System.out.println("Se va a crear una biblioteca, introduce los datos necessarios");
        biblioteca = crearBiblioteca(biblioteca);
        //Crear almenos un bibliotecario:
        System.out.println("Antes de iniciar el sistema es necessario ingresar un bibliotecario:");
        crearBibliotecario(biblioteca);
        System.out.println("Para empezar identificacte: ");
        Bibliotecario.identificarse(biblioteca.getListaPersonas());
        int opcionPrincipal = menuPrincipal(biblioteca);
        while(opcionPrincipal != 6) {
            try {
                switch (opcionPrincipal) {
                    case 1://Crear/Modificar Personas
                        menuCrearModificarPersonas();
                        opcionPrincipal = menuPrincipal(biblioteca);
                        break;
                    case 2://Crear/Modificar Libros
                        menuCrearModificarLibros();
                        opcionPrincipal = menuPrincipal(biblioteca);
                        break;
                    case 3://Reservas Libros
                        menuReservasLibros();
                        opcionPrincipal = menuPrincipal(biblioteca);
                        break;
                    case 4://Buscar Libros
                        menuBuscarLibros();
                        opcionPrincipal = menuPrincipal(biblioteca);
                        break;
                    case 5:
                        System.out.println("\n ---Sesion cerrada--- \n");
                        System.out.print("Pulsa enter para continuar");
                        scanner.nextLine();
                        System.out.println("IDENTIFICATE: ");
                        Bibliotecario.identificarse(biblioteca.getListaPersonas());
                        opcionPrincipal = menuPrincipal(biblioteca);
                        break;

                    case 6://Terminar programa
                        System.out.println("Gracias por usar la aplicacion");
                        break;
                    default:
                        System.out.println("\nOPCION INVALIDA\n");
                        opcionPrincipal = menuPrincipal(biblioteca);
                        break;
                }
            }catch(Exception e){
                System.out.println("-------------------");
                System.out.println("------ ERROR ------");
                System.out.println(e);
                System.out.println("-------------------");
                opcionPrincipal = menuPrincipal(biblioteca);

            }

        }
        System.out.println("Fin del programa");

    }

    //Funcion para crear una bibliota
    public static Biblioteca crearBiblioteca(Biblioteca biblioteca){
        System.out.print("Nombre de la biblioteca: ");
        biblioteca.setNombreBiblioteca(scanner.nextLine());
        ArrayList<Libro> libros = new ArrayList<Libro>();
        biblioteca.setListaLibros(libros);
        ArrayList<Persona> personas = new ArrayList<Persona>();
        biblioteca.setListaPersonas(personas);
        return biblioteca;

    }

    //Crear un bibliotecario y añadirlo en la biblioteca
    public static void crearBibliotecario(Biblioteca biblioteca){

        Bibliotecario bibliotecario = new Bibliotecario();
        System.out.print("Nombre: ");
        bibliotecario.setNombre(scanner.nextLine());
        System.out.print("Apellido 1: ");
        bibliotecario.setApellido1(scanner.nextLine());
        System.out.print("Apellido 2: ");
        bibliotecario.setApellido2(scanner.nextLine());
        System.out.print("Edad: ");
        bibliotecario.setEdad(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Puesto de trabajo: ");
        bibliotecario.setPuestoTrabajo(scanner.nextLine());
        boolean bool = false;
        do {
            try {
                System.out.print("NIF: ");
                bibliotecario.setNif(scanner.nextLine());
                bool = true;
            } catch (Excepciones e) {
                System.out.println(e.getMessage());
            }
        }while (bool == false);
        System.out.print("Contraseña: ");
        bibliotecario.setContraseña(scanner.nextLine());
        biblioteca.getListaPersonas().add(bibliotecario);


    }

    //Menu principal
    public static int menuPrincipal(Biblioteca biblioteca){
        System.out.println("---BIBLIOTECA---");
        System.out.println("Que deseas hacer? ");
        System.out.println("1) Crear/Modificar Personas");
        System.out.println("2) Crear/Modificar Libros");
        System.out.println("3) Reservas Libros");
        System.out.println("4) Buscar Libros");
        System.out.println("5) Cerrar sesion");
        System.out.println("6) Terminar programa (Se borra todo)");

        System.out.print("> ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;


    }
    //Menu que pide al usuario si quiere modificar o crear personas
    public static void menuCrearModificarPersonas(){
        System.out.println("Que deseas hacer: ");
        System.out.println("1) Añadir una persona");
        System.out.println("2) Cambiar correo bibliotecario");
        System.out.println("3) Cambiar contraseña usuario");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        crearModificarPersonas(opcion);
    }

    public static void crearModificarPersonas(int opcion){
        switch (opcion) {
            case 1:
                biblioteca.setListaPersonas(biblioteca.añadirPersona(biblioteca.getListaPersonas()));
                break;
            case 2:
                //Pedir datos
                System.out.print("Nif del bibliotecario a cambiar contraseña: ");
                String nif = scanner.nextLine();
                System.out.print("Nueva contraseña: ");
                String contrasenya = scanner.nextLine();
                boolean bool = false;
                for(int i = 0; i < biblioteca.getListaPersonas().size(); i++){
                    //Encontrar los bibliotecarios
                    if(biblioteca.getListaPersonas().get(i) instanceof Bibliotecario){
                        //Cambiar contraseña
                       bool = ((Bibliotecario)biblioteca.getListaPersonas().get(i)).cambiarContraseña(nif, contrasenya);

                    }
                }
                if(!bool){
                    System.out.println("El bibliotecario no ha sido encontrado");
                }
                break;
            case 3:
                //Pedir datos
                System.out.print("Telefono del usuario a cambiar contraseña: ");
                String telefono = scanner.nextLine();
                System.out.print("Nuevo correo: ");
                String correo = scanner.nextLine();
                boolean bool2 = false;
                for(int i = 0; i < biblioteca.getListaPersonas().size(); i++){
                    //Encontrar los bibliotecarios
                    if(biblioteca.getListaPersonas().get(i) instanceof Usuario){
                        //Cambiar contraseña
                        bool2 = ((Usuario)biblioteca.getListaPersonas().get(i)).cambiarContraseña(telefono, correo);

                    }
                }
                if(!bool2){
                    System.out.println("El usuario no ha sido encontrado");
                }
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }

    }

    //Mostrar menu para crear o modificar los libros
    public static void menuCrearModificarLibros(){
        System.out.println("Que deseas hacer: ");
        System.out.println("1) Crear un libro");
        System.out.println("2) Eliminar un libro ");
        System.out.println("3) Copiar un libro ya creado y modificarlo si es necessario");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        crearModificarLibros(opcion);
    }

    //Modificar o crear libros
    public static void crearModificarLibros(int opcion){
        switch (opcion){
            case 1://Crear un libro
                Libro.añadirLibro(biblioteca.getListaLibros());
                break;
            case 2://Eliminar un libro
                Libro.eliminarLibro(biblioteca.getListaLibros());
                break;
            case 3://copiar un libro ya creado y modificarlo si es necessario
                int lugarEnLaLista = Libro.buscarPorISBN(biblioteca.getListaLibros());//Encontrar en que lugar esta el libro
                biblioteca.getListaLibros().add(Libro.añadirLibroCopia(biblioteca.getListaLibros().get(lugarEnLaLista), biblioteca.getListaLibros()));//Añadir el libro copia
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    //Menu para las Reservas de libros
    public static void menuReservasLibros(){
        System.out.println("Que deseas hacer: ");
        System.out.println("1) Reservar libros");
        System.out.println("2) Ver informacion de una reserva");
        System.out.println("3) Devolver libros ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        reservasLibros(opcion);
    }
    //Metodo que hace alguna de las opciones del menu de reservas de libros
    public static void reservasLibros(int opcion){
        Reserva reserva = new Reserva();
        switch(opcion){
            case 1://Reservar libros
                 reserva = Bibliotecario.reservarLibro(biblioteca.getListaPersonas(), biblioteca.getListaLibros());//Crear una reserva
                 if(reserva != null){
                     biblioteca.getListaReservas().add(reserva);//Añadir la reserva

                 }
            case 2://Ver informacion de una reserva
                    reserva = reserva.encontrarReserva(biblioteca.getListaReservas());//Enconctrar la reserva
                    if(reserva != null){
                        reserva.mostrarInfoChula();//Mostrar bien la reserva
                    }
                    else{
                        System.out.println("No se ha encontrado la reserva");
                    }
                    break;
            case 3://Devolver libros
                Bibliotecario.devolverLibro(biblioteca.getListaPersonas(), biblioteca.getListaLibros(), biblioteca.getListaReservas());//Se elimina de la lista reservas la reserva
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;

        }
    }

    public static void menuBuscarLibros(){
        System.out.println("1) Buscar Libros por ISBN");
        System.out.println("2) Buscar Libros por Titulo");
        System.out.println("3) Mostrar todos los libros");
        System.out.println("4) Ver los libros disponibles");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        buscarLibros(opcion);
    }

    public static void buscarLibros(int opcion){
        switch(opcion){
            case 1://Buscar libros por ISBN
                int lugarLibro = Libro.buscarPorISBN(biblioteca.getListaLibros());
                if(lugarLibro != -1) {
                    biblioteca.getListaLibros().get(lugarLibro).toString();

                }
                else{
                    System.out.println("El libro no se ha encontrado");
                }
            case 2://Buscar Libros por Titulo
                Libro.buscarPorTitulo(biblioteca.getListaLibros());
                break;
            case 3://Mostrar todos los libros
                biblioteca.mostrarLibros();
                break;
            case 4://Ver los libros disponibles
                biblioteca.mostrarLibrosDisponibles();
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;

        }
    }

}
