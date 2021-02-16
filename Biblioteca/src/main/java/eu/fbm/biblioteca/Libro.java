/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fbm.biblioteca;

import static eu.fbm.biblioteca.Main.scanner;
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

    public Libro(int isbn, String titulo, String autor, String editorial, int numCopias, int numCopiasDisponibles) {
        contadorLibros++;
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setNumCopias(numCopias);
        this.setNumCopiasDisponibles(numCopiasDisponibles);
    }
    
    public Libro(Libro libro){
        contadorLibros++;
        this.setIsbn(libro.isbn);
        this.setTitulo(libro.titulo);
        this.setAutor(libro.autor);
        this.setEditorial(libro.editorial);
        this.setNumCopias(libro.numCopias);
        this.setNumCopiasDisponibles(libro.numCopiasDisponibles);
    }
    
    
    //GETTERS Y SETTERS
    public static int getContadorLibros(){
        return contadorLibros;
    }
    
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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
        libro.setIsbn(isbn);
        
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
    public static void EliminarLibro(ArrayList<Libro> lista){
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
    public static int BuscarPorISBN(ArrayList<Libro> lista){
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
    public static void BuscarPorTitulo(ArrayList<Libro> lista){
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
               System.out.println(lista.get(i).getTitulo());
            }
        }
    }
    
    //Hacer reserva de libro
    public static ArrayList<Libro> hacerReserva(ArrayList<Libro> lista){
        //Pedir el ISBN
        System.out.println("Introduce el ISBN del libro a reservar: ");
        int isbn = scanner.nextInt();
        //Comprobar si hay copias disponibles
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getIsbn() == isbn){
                if(lista.get(i).getNumCopiasDisponibles() == 0){
                    System.out.println("No hay copias disponibles del libro");
                    return lista;
                }
                else{
                    System.out.println("Hay un total de: " + lista.get(i).getNumCopiasDisponibles() + " libros disponibles");
                }
            }
        }
        System.out.println("Cuantos quieres reservar? ");
        int cantidad = scanner.nextInt();
        
        //Reservar la cantidad de libros deseada
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getIsbn() == isbn){
                while((lista.get(i).numCopiasDisponibles - cantidad) < 0){
                    System.out.println("No hay tantas copias disponibles, pon menos cantidad: ");
                    cantidad = scanner.nextInt();
                }
               lista.get(i).setNumCopiasDisponibles(lista.get(i).numCopiasDisponibles - cantidad);
               
            }
        }
        return lista;
    }
    
    
    
    
    
}
