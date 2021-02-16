
package eu.fbm.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //SCANNER
    public static Scanner scanner = new Scanner(System.in);
    
    //MAIN
    public static void main(String[] args) {
        //Declaracion de variables
        ArrayList<Biblioteca> listaBibliotecas = new ArrayList();
        Biblioteca biblioteca;
        int opcionUsuario = MenuPrincipal();
        //Switch para el menu principal del usuario
        while(opcionUsuario != 4){
            switch(opcionUsuario){
                case 1://1. Crear una biblioteca
                    biblioteca = crearBiblioteca();
                    listaBibliotecas.add(biblioteca);
                    break;
                case 2://2. Gestionar los libros de una biblioteca
                    biblioteca = encontrarBiblioteca(listaBibliotecas);
                    int opcionGestionLibros = opcionGestionLibros();
                    //Switch para la gestion del libros
                    switch(opcionGestionLibros){
                        case 1://1. Ver libros actuales
                            biblioteca.mostrarLibros();
                            break;

                        case 2://2. Ver libros disponibles
                            biblioteca.mostrarLibrosDisponibles();
                            break;

                        case 3://3. Añadir libro
                            Libro.añadirLibro(biblioteca.getListaLibros());
                            break;
                        case 4://4. Eliminar libro
                            Libro.EliminarLibro(biblioteca.getListaLibros());
                            break;
                        case 5://5. Buscar libro por ISBN
                            Libro.BuscarPorISBN(biblioteca.getListaLibros());
                            break;
                        case 6://6. Buscar libro por Titulo
                            Libro.BuscarPorTitulo(biblioteca.getListaLibros());
                            break;
                        case 7://7. Hacer reservas de libros
                            Libro.hacerReserva(biblioteca.getListaLibros());
                            break;
                        default:
                            System.out.println("La opcion elegida no existe");
                            break;
                    }
                    break;

                case 3://3. Gestionar el personal de la biblioteca
                    biblioteca = encontrarBiblioteca(listaBibliotecas);
                    int opcionGestionPersona = opcionGestionPersonal();
                    //Switch para la gestion del personal
                    switch(opcionGestionPersona){
                        case 1://1. Añadir persona
                            Persona.añadirPersona(biblioteca.getListaPersonal());
                            break;

                        case 2://2. Eliminar persona
                            Persona.eliminarPersona(biblioteca.getListaPersonal());
                            break;

                        default:
                            System.out.println("La opcion elegida no existe");
                            break;

                    }
                    break;
                default:
                    System.out.println("La opcion elegida no existe");
                    break;
            }
            
            opcionUsuario = MenuPrincipal();
        }
    }
    


    
    //Lista de opciones para el usuario
    public static int MenuPrincipal(){
        System.out.println("--------------------------");
        System.out.println("QUE DESEAS HACER? ");
        System.out.println("1. Crear una biblioteca");
        System.out.println("2. Gestionar los libros de una biblioteca");
        System.out.println("3. Gestionar el personal de la biblioteca");
        System.out.println("4. Salir");
        System.out.println("--------------------------");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    
    //Devovler la biblioteca adecuada
    public static Biblioteca encontrarBiblioteca(ArrayList<Biblioteca> listaBibliotecas){
        //pedir nombre de la biblioteca
        System.out.println("Introduce el nombre de la biblioteca a gestionar");
        String nombreBiblioteca = scanner.nextLine();
        Biblioteca biblioteca = null;
        //loopear mientras la biblioteca no se haya encontrado.
        while(biblioteca == null){
            //buscar por la lista de bibliotecas
            for(int i = 0; i < listaBibliotecas.size(); i++){
                //Si encuentra la biblioteca
                if(listaBibliotecas.get(i).getNombreBiblioteca().toLowerCase().contentEquals(nombreBiblioteca.toLowerCase())){
                    biblioteca = listaBibliotecas.get(i);
                }
            }
            //Si no ha encontrado la biblioteca repetir
            if(biblioteca == null){
                System.out.println("Esa biblioteca no existe, introduzca otro nombre");
                nombreBiblioteca = scanner.nextLine();
            }
            
        }
        return biblioteca;
    }
    
    
    //Crear una biblioteca
    public static Biblioteca crearBiblioteca(){
        System.out.println("introduce el nombre de la biblioteca: ");
        String nombreBiblioteca = scanner.nextLine();
        ArrayList<Libro> listaLibros = new ArrayList();
        ArrayList<Persona> listaPersonal = new ArrayList();
        Biblioteca biblioteca = new Biblioteca(nombreBiblioteca, listaLibros, listaPersonal);
        return biblioteca;

    }
    
    //Opciones de gestion de libro
    public static int opcionGestionLibros(){
        System.out.println("QUE DESEAS HACER? ");
        System.out.println("1. Ver libros actuales");
        System.out.println("2. Ver libros disponibles");
        System.out.println("3. Añadir libro");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Buscar libro por ISBN");
        System.out.println("6. Buscar libro por Titulo");
        System.out.println("7. Hacer reservas de libros");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    
    //Opciones de gestion de personas
    public static int opcionGestionPersonal(){
        System.out.println("QUE DESEAS HACER? ");
        System.out.println("1. Añadir persona");
        System.out.println("2. Eliminar persona");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    
}
