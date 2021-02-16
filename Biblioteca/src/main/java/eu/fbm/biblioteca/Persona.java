/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fbm.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alfon
 */
public class Persona {
    //Variables
    public static Scanner scanner = new Scanner(System.in);
    private String nombre;
    private String apellidos;
    private String NIF;
    private String Contraseña;
    
    //CONSTRUCTORES
    public Persona(String nombre, String apellidos, String NIF, String Contraseña){
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setNIF(NIF);
        this.setContraseña(Contraseña);
    }
    
    public Persona(Persona persona){
        this.setNombre(persona.nombre);
        this.setApellidos(persona.apellidos);
        this.setNIF(persona.NIF);
        this.setContraseña(persona.Contraseña);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", Contraseña=" + Contraseña + '}';
    }

    
    
    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        while(contraseña.length() < 8){
            System.out.println("La contraseña debe tener almenos 8 caracteres");
            contraseña = scanner.nextLine();
        }
        this.Contraseña = Contraseña;
    }
    
    //METODOS
    //Añadir una persona
    public static ArrayList<Persona> añadirPersona(ArrayList<Persona> listaPersonas){
        //Pedir datos de la persona
        System.out.println("Nombre de la persona");
        String nombre = scanner.nextLine();
        System.out.println("Apellidos de la persona");
        String apellidos = scanner.nextLine();
        System.out.println("NIF de la persona");
        String NIF = scanner.nextLine();
        System.out.println("Contraseña de la persona");
        String contraseña = scanner.nextLine();
        //Llamar al constructor de la nueva persona
        Persona nuevaPersona = new Persona(nombre, apellidos, NIF, contraseña);
        //Añadirla a la lista
        listaPersonas.add(nuevaPersona);
        return listaPersonas;
    }
    
    //Eliminar una persona
    public static ArrayList<Persona> eliminarPersona(ArrayList<Persona> listaPersonas){
        System.out.println("DNI de la persona");
        String NIF = scanner.nextLine();
        for(int i = 0; i < listaPersonas.size(); i++){
            if(listaPersonas.get(i).getNIF() == NIF){
                listaPersonas.remove(i);
                System.out.println("Persona eliminada");
            }
        }
        return listaPersonas;
        
    }
    
    
    
    
}

