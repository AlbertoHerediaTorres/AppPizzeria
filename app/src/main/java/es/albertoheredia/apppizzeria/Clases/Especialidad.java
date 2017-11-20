package es.albertoheredia.apppizzeria.Clases;

/**
 * Created by H on 15/11/2017.
 */

public class Especialidad {

    String nombre;
    double precio;

    public Especialidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

    public Especialidad(){

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
