/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperprueba.model;

/**
 *
 * @author Gianmarco Tantaruna
 */
public class Actor {
    private String nombre;
    private String apellidos;
    
    public Actor() {
    }

    public Actor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellidos = apellido;
    }

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

    @Override
    public String toString() {
        return "Actor{" + "nombre=" + nombre + ", apellido=" + apellidos + '}';
    }
    
    
    
}
