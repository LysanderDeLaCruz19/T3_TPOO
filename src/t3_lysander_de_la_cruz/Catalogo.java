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

public class Catalogo {
    private ArrayList<Producto> productos;

    public Catalogo() {
    productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
     productos.add(producto);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null; //No se encontró el producto
    }
    public ArrayList<Producto> getProductos() {
    return productos;
    }
}


