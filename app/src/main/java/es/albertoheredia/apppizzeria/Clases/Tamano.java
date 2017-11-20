/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.albertoheredia.apppizzeria.Clases;
/**
 *
 * @author H
 */
public class Tamano {
    
    String nombre;
    double precio;

    public Tamano(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Tamano() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
