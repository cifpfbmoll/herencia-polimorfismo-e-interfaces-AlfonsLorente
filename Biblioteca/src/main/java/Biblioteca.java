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
public class Biblioteca {
    //VARIABLES
    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibros = new ArrayList();
    private ArrayList<Persona> listaPersonas = new ArrayList();
    private ArrayList<Reserva> listaReservas = new ArrayList();
    protected static Scanner scanner = new Scanner(System.in);

    //CONSTRUCTORES
    public Biblioteca(){
    
    }

    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas, ArrayList<Reserva> listaReservas) {
        this.setNombreBiblioteca(nombreBiblioteca);
        this.setListaLibros(listaLibros);
        this.setListaPersonas(listaPersonas);
        this.setListaReservas(listaReservas);
    }
    
    public Biblioteca(Biblioteca biblioteca){
        this.setNombreBiblioteca(biblioteca.getNombreBiblioteca());
        this.setListaLibros(biblioteca.getListaLibros());
        this.setListaPersonas(biblioteca.getListaPersonas());
        this.setListaReservas(biblioteca.getListaReservas());
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombreBiblioteca='" + nombreBiblioteca + '\'' +
                ", listaLibros=" + listaLibros +
                ", listaPersonas=" + listaPersonas +
                ", listaReservas=" + listaReservas +
                '}';
    }

    //GETTERS Y SETTERS

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }
    
    public void setNombreBiblioteca(String nombreBiblioteca) {
        //Preparar el setter para que onga la primera letra en mayuscula
        char fLetter1 = nombreBiblioteca.charAt(0);
        String fLetter2 = nombreBiblioteca.toUpperCase();
        //Cambiar el primer caracter que coincida con la string de fLetter1 i cambiarlo por la mayusucla de fLetter2
        nombreBiblioteca.replaceFirst(String.valueOf(fLetter1),String.valueOf(fLetter2.charAt(0)));
        this.nombreBiblioteca = nombreBiblioteca;
        
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void setListaPersonas(ArrayList<Persona> ListaPersonas) {
        this.listaPersonas = ListaPersonas;
    }
    
    //METODOS
    
    //Mostrar la lista de los libros por pantalla
    public void mostrarLibros(){
        System.out.println("-----------------------");
        //Loopear por cada libro y enseñar su informacion
        for(int i = 0; i < getListaLibros().size(); i++){
            System.out.println("Libro " + i + ":");
            System.out.println("ISBN: " + getListaLibros().get(i).getIsbn());
            System.out.println("Titulo: " + getListaLibros().get(i).getTitulo());
            System.out.println("Autor: " + getListaLibros().get(i).getAutor());
            System.out.println("Editorial: " + getListaLibros().get(i).getEditorial());
            System.out.println("Numero de copias totales: " + getListaLibros().get(i).getNumCopias());
            System.out.println("Numero de copias disponibles: " + getListaLibros().get(i).getNumCopiasDisponibles());
            System.out.println("-----------------------");

        }
        
    }

    //Menu para añadir personas
    public ArrayList<Persona> añadirPersona(ArrayList<Persona> listaPersona) {

        //Pedir una opcion al usuario
        System.out.println("QUE DESEAS HACER? ");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Añadir bibliotecario");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        //Dependiendo de la opcion se añadira un usuario o un bibliotecario
        if (opcion == 1) {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.solicitarDatosPersona();
            listaPersona.add(nuevoUsuario);
        } else if (opcion == 2) {
            Bibliotecario nuevoBibliotecario = new Bibliotecario();
            nuevoBibliotecario.solicitarDatosPersona();
            listaPersona.add(nuevoBibliotecario);
        } else {
            System.out.println("No has introducido una opcion correcta");
        }
        return listaPersona;
    }


    //Mostrar todos los libros que estan disponibles
    public void mostrarLibrosDisponibles(){
        System.out.println("Los libros que estan disponibles son: ");
        //Loopear por cada libro y enseñar si esta disponibe
        for(int i = 0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getNumCopiasDisponibles() > 0){
                System.out.println("- " + listaLibros.get(i).getTitulo());
            }
        }
        
    }


}
    

    

