/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fbm.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author alfon
 */
public class Biblioteca {
    //VARIABLES
    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Persona> listaPersonal;
    
    //CONSTRUCTORES
    public Biblioteca(){
    
    }

    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        this.setNombreBiblioteca(nombreBiblioteca);
        this.setListaLibros(listaLibros);
        this.setListaPersonal(listaPersonal);
    }
    
    public Biblioteca(Biblioteca biblioteca){
        this.setNombreBiblioteca(biblioteca.nombreBiblioteca);
        this.setListaLibros(biblioteca.listaLibros);
        this.setListaPersonal(biblioteca.listaPersonal);
    }
    
    @Override
    public String toString() {
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", listaLibros=" + listaLibros + ", listaPersonal=" + listaPersonal + '}';
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

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }
    
    //METODOS
    
    //Mostrar la lista de los libros por pantalla
    public void mostrarLibros(){
        System.out.println("-----------------------");
        //Loopear por cada libro y enseñar su informacion
        for(int i = 0; i < listaLibros.size(); i++){
            System.out.println("Libro " + i + ":");
            System.out.println("ISBN: " + listaLibros.get(i).getIsbn());
            System.out.println("Titulo: " + listaLibros.get(i).getTitulo());
            System.out.println("Autor: " + listaLibros.get(i).getAutor());
            System.out.println("Editorial: " + listaLibros.get(i).getEditorial());
            System.out.println("Numero de copias totales: " + listaLibros.get(i).getNumCopias());
            System.out.println("Numero de copias disponibles: " + listaLibros.get(i).getNumCopiasDisponibles());
            System.out.println("-----------------------");

        }
        
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
    

    

