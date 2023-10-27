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

public class Camisa extends Producto {
    public Camisa(String nombre, String descripcion, double precio, ArrayList<String> tallasDisponibles) {
        super(nombre, descripcion, precio, tallasDisponibles);
    }

    @Override
    public String getTipo() {
        return "Camisa";
    }
}
