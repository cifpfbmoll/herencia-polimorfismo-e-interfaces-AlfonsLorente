/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alfon
 */
public class Libro {
    
    //Variables
    private static Scanner scanner = new Scanner(System.in);
    private int isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisponibles;
    private static int contadorLibros = 0;

    //Constructores
    public Libro(){
        contadorLibros++;
        
    }

    public Libro(int isbn, String titulo, String autor, String editorial, int numCopias, int numCopiasDisponibles, ArrayList<Libro> libros){
        contadorLibros++;
        this.setIsbn(isbn, libros);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setNumCopias(numCopias);
        this.setNumCopiasDisponibles(numCopiasDisponibles);
    }
    
    public Libro(Libro libro, ArrayList<Libro> libros){
        contadorLibros++;
        this.setIsbn(libro.isbn, libros);
        this.setTitulo(libro.titulo);
        this.setAutor(libro.autor);
        this.setEditorial(libro.editorial);
        this.setNumCopias(libro.numCopias);
        this.setNumCopiasDisponibles(libro.numCopiasDisponibles);
    }

    //ToString


    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", numCopias=" + numCopias +
                ", numCopiasDisponibles=" + numCopiasDisponibles +
                '}';
    }

    //GETTERS Y SETTERS
    public static int getContadorLibros(){
        return contadorLibros;
    }
    
    public int getIsbn() {
        return isbn;
    }

    //Se le pasa una lista de libros para la comprobacion del ISBN
    public void setIsbn(int isbn, ArrayList<Libro> libros) {
        boolean isbnRepetido = false;
        int i = 0;
        if(libros.size()==0){
            this.isbn = isbn;

        }else {
            while (!isbnRepetido && libros.size() > i) {
                if (isbn == libros.get(i).getIsbn()) {
                    isbnRepetido = true;
                }
                i++;
            }
            if (isbnRepetido) {
                System.out.println("Ya hay un libro con ese ISBN.");
                System.out.print("Introduce otro isbn: ");
                isbn = scanner.nextInt();
                scanner.nextLine();
                setIsbn(isbn, libros);
            } else {
                this.isbn = isbn;

            }
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        while(numCopias < 1){
            System.out.println("Debe de introducirse almenos un libro");
            numCopias = scanner.nextInt();
            scanner.nextLine();
        }
        
        this.numCopias = numCopias;
    }

    public int getNumCopiasDisponibles() {
        return numCopiasDisponibles;
    }

    public void setNumCopiasDisponibles(int numCopiasDisponibles) {
        this.numCopiasDisponibles = numCopiasDisponibles;
    }
    
    //Cantidad de libros reservados
    public int getLibrosReservados(){
        int cantidad = this.getNumCopiasDisponibles() - this.getNumCopias();
        return cantidad;
    }
    
    //FUNCIONES
    //Funcion para añadir libro
    public static void añadirLibro(ArrayList<Libro> lista){
        contadorLibros++;
        //Crear objeto
        Libro libro = new Libro();
        //Preguntar al usuario informacion sobre el libro y 
        System.out.println("Introduce ISBN: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();
        libro.setIsbn(isbn, lista);
        
        System.out.println("Introduce titulo: ");
        String titulo =scanner.nextLine();
        libro.setTitulo(titulo);
        
        System.out.println("Introduce autor: ");
        String autor = scanner.nextLine();
        libro.setAutor(autor);
        
        System.out.println("Introduce editorial: ");
        String editorial = scanner.nextLine();
        libro.setEditorial(editorial);
        
        System.out.println("Introduce el numero de copias: ");
        int numCopias = scanner.nextInt();
        scanner.nextLine();
        libro.setNumCopias(numCopias);
        
        System.out.println("Introduce el numero de copias disponibles: ");
        int numCopiasDisponibles = scanner.nextInt();
        scanner.nextLine();
        libro.setNumCopiasDisponibles(numCopiasDisponibles);
        
        //Añadir libro a la lista
        lista.add(libro);
        
    }
    
    //Lista para eliminar un libro
    public static void eliminarLibro(ArrayList<Libro> lista){
        contadorLibros--;
        System.out.println("Introduce el ISBN del libro que desees eliminar");
        int isbn = scanner.nextInt();
        //loop por la cantidad de libros de la lista
        for(int i = 0; i < lista.size(); i++){
            //Si encuentra el libro y no esta reservado se elimina
            if(lista.get(i).getIsbn() == isbn){
                if(lista.get(i).getNumCopiasDisponibles()==lista.get(i).getNumCopias()){
                    lista.remove(i);
                    System.out.println("Persona eliminada");

                }
                //Si esta reservado no se elimina
                else{
                    System.out.println("El libro seleccionado no puede ser eliminado porque tiene reservas");
                }

            }
        }
    }
    
    //Buscar el libro por ISBN
    public static int buscarPorISBN(ArrayList<Libro> lista){
        System.out.println("Introduce el ISBN del libro que desees encontrar");
        int isbn = scanner.nextInt();
        //loop por la cantidad de libros de la lista
        for(int i = 0; i < lista.size(); i++){
            //Cuando encuentra el ISBN devuelve la posicion del libro;
            if(lista.get(i).getIsbn() == isbn){
                return i;
            }
        }
        //Sino devuelve -1
        return -1;
    }
    
    //Buscar el libro por titulo
    public static void buscarPorTitulo(ArrayList<Libro> lista){
        System.out.println("Introduce el titulo del libro que desees encontrar");
        String titulo = scanner.nextLine();

        //Poner el texto en minusculas
        titulo = titulo.toLowerCase();
        System.out.println("Los libros que coinciden con ese titulo son: ");
        //loop por la cantidad de libros de la lista
        for(int i = 0; i < lista.size(); i++){
            //Todos los que coincidan con el texto introdcido por el usuario seran printeados
            String tituloLibro = lista.get(i).getTitulo();
            tituloLibro = tituloLibro.toLowerCase();
            if(lista.get(i).getTitulo().contains(titulo)){
               lista.get(i).toString();
            }
            System.out.println("-----------------");
        }
    }

    //Funcion para mostrar un menu en el que se pide una opcion y se devuelve la opcion
    private static int menuModificarLibro(){
        int opcion;
        System.out.println("Que dato quieres cambiar del libro? ");
        System.out.println("1) ISBN");
        System.out.println("2) Titulo");
        System.out.println("3) Autor");
        System.out.println("4) Editorial");
        System.out.println("5) Cantidad de copias totales");
        System.out.println("6) Cantidad de copias disponibles");
        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;

    }

    //Funcion para cambiar los atributos de la copia del libro
    private static Libro cambiarDatoLibro(Libro libro, int opcion, ArrayList<Libro> libros){
        switch (opcion){
            case 1:
                System.out.print("Introduce el ISBN: ");
                libro.setIsbn(scanner.nextInt(), libros);
                scanner.nextLine();
                break;
            case 2:
                System.out.print("Introduce el titulo: ");
                libro.setTitulo(scanner.nextLine());
                break;

            case 3:
                System.out.print("Introduce el nombre del autor: ");
                libro.setAutor(scanner.nextLine());
                break;
            case 4:
                System.out.print("Introduce la editorial: ");
                libro.setAutor(scanner.nextLine());

            case 5:
                System.out.print("Introduce la cantidad de copias del libro totales: ");
                libro.setNumCopias(scanner.nextInt());
                scanner.nextLine();
                break;

            case 6:
                System.out.print("Introduce la cantidad de copias disponibles del libro: ");
                libro.setNumCopiasDisponibles(scanner.nextInt());
                scanner.nextLine();
                break;
            default:
                System.out.print("OPCION ELEGIDA INCORRECTA");

        }
        return libro;
    }

    //Funcion para crear la copia de un libro y modificarla
    public static Libro añadirLibroCopia(Libro libro, ArrayList<Libro> libros){
        Libro copia = new Libro(libro, libros);//Hacer copia
        System.out.println("Copia de libro creada");
        boolean bool = false;
        while(!bool){//Repetir mientras bool sea false
            //Pedir al usuario si quiere cambiar algun dato
            System.out.println("Quieres cambiar algun dato del libro?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int cambiarDato = scanner.nextInt();
            scanner.nextLine();
            if(cambiarDato == 1){//Si
                int opcion = menuModificarLibro();//Mostrar menu
                copia = cambiarDatoLibro(copia, opcion, libros);//Modificar libro
            }else if(cambiarDato == 2){//No
                bool = true;//Cambiar valor a true

            }else{
                System.out.println("No has introducido un valor correcto");
            }

        }
        return copia;
    }

    
    
    
}
