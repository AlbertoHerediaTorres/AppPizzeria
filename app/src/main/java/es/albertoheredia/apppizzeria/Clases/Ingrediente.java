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
public class Ingrediente {

    String nombre;
    int precio;

    public Ingrediente(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Ingrediente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
