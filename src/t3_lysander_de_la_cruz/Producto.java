/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t3_lysander_de_la_cruz;

/**
 *
 * @author lysan
 */
import java.util.ArrayList;

public abstract class Producto {
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected ArrayList<String> tallasDisponibles;

    public Producto(String nombre, String descripcion, double precio, ArrayList<String> tallasDisponibles) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tallasDisponibles = tallasDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<String> getTallasDisponibles() {
        return tallasDisponibles;
    }

    public abstract String getTipo();
}


