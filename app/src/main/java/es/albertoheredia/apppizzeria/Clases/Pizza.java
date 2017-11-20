
package es.albertoheredia.apppizzeria.Clases;
import es.albertoheredia.apppizzeria.Clases.*;

import java.util.ArrayList;


public class Pizza {
    
    ArrayList<Ingrediente> ingredientes;
    boolean especialidad;
    Tamano tamano;

    public Pizza(ArrayList<Ingrediente> ingredientes, boolean especialidad, Tamano tamano) {
        this.ingredientes = ingredientes;
        this.especialidad = especialidad;
        this.tamano = tamano;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(boolean especialidad) {
        this.especialidad = especialidad;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }
    
    public void addIngrediente(Ingrediente i){
        this.ingredientes.add(i);
    }
    
    public int getPrecio(){
        
        int precio = 0;
        for (int i = 0; i < this.ingredientes.size(); i++) {
            precio += this.ingredientes.get(i).getPrecio();
        }
        
        precio += this.tamano.getPrecio();
        
        return precio;
    }
    
    
}
