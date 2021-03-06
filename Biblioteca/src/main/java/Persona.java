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
//Esta clase tiene sentido que sea abstacta porque nunca es usada en el Main, ni se crean instancias de esta, solo esta para sentar la base de subclases.
public abstract class  Persona {
    //Variables
    protected static Scanner scanner = new Scanner(System.in);
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    
    //CONSTRUCTORES

    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setEdad(edad);
    }

    public Persona(Persona persona) {
        this.setNombre(persona.getNombre());
        this.setApellido1(persona.getApellido1());
        this.setApellido2(persona.getApellido2());
        this.setEdad(persona.getEdad());
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                '}';
    }


    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Solicitar los datos de una persona i por tanto crear una
    public void solicitarDatosPersona(){
        //Pedir datos de la persona
        System.out.print("Nombre de la persona: ");
        this.setNombre(scanner.nextLine());
        System.out.print("Primer apellido de la persona: ");
        this.setApellido1(scanner.nextLine());
        System.out.print("Segundo apellido de la persona: ");
        this.setApellido2(scanner.nextLine());
        System.out.print("Edad de la persona: ");
        this.setEdad(scanner.nextInt());
        scanner.nextLine();
    }

    //Funcion abstracta para el cambio de contraseña
    public abstract boolean cambiarContraseña(String usuario, String contraseña);




}

