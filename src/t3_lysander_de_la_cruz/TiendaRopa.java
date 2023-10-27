/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t3_lysander_de_la_cruz;

/**
 *
 * @author lysan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TiendaRopa {
    private Catalogo catalogo;
    private JFrame frame;
    private JPanel panel;
    private JTextField nombreField, descripcionField, precioField, tallaField;
    private JTextArea catalogoTextArea;

    public TiendaRopa() {
        catalogo = new Catalogo(); //Inicia el catálogo

        frame = new JFrame("Tienda de Ropa de Miguelito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField();
        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField();
        JLabel tallaLabel = new JLabel("Tallas Disponibles:");
        tallaField = new JTextField();

        JButton agregarButton = new JButton("Agregar Producto");
        JButton buscarButton = new JButton("Buscar Producto");

        catalogoTextArea = new JTextArea();
        catalogoTextArea.setEditable(false);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(descripcionLabel);
        panel.add(descripcionField);
        panel.add(precioLabel);
        panel.add(precioField);
        panel.add(tallaLabel);
        panel.add(tallaField);
        panel.add(agregarButton);
        panel.add(new JLabel());
        panel.add(buscarButton);
        panel.add(new JLabel());
        panel.add(new JLabel()); 
        panel.add(new JLabel("Catálogo de Productos:"));
        panel.add(new JScrollPane(catalogoTextArea)); 
     // Use JScrollPane para el área de texto

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void agregarProducto() {
        String nombre = nombreField.getText();
        String descripcion = descripcionField.getText();
        double precio = Double.parseDouble(precioField.getText());
        String[] tallas = tallaField.getText().split(", ");
        Producto producto = new Camisa(nombre, descripcion, precio, new ArrayList<String>() {{
            for (String talla : tallas) {
                add(talla);
            }
        }});
        catalogo.agregarProducto(producto);
        actualizarCatalogo();
    }

    private void buscarProducto() {
        String nombre = nombreField.getText();
        Producto producto = catalogo.buscarProductoPorNombre(nombre);
        if (producto != null) {
            descripcionField.setText(producto.getDescripcion());
            precioField.setText(String.valueOf(producto.getPrecio()));
            tallaField.setText(String.join(", ", producto.getTallasDisponibles()));
        } else {
            // limpiar los campos
            descripcionField.setText("");
            precioField.setText("");
            tallaField.setText("");
        }
    }

    private void actualizarCatalogo() {
        catalogoTextArea.setText("");
        for (Producto producto : catalogo.getProductos()) {
            catalogoTextArea.append("Nombre: " + producto.getNombre() + "\n");
            catalogoTextArea.append("Descripción: " + producto.getDescripcion() + "\n");
            catalogoTextArea.append("Precio: $" + producto.getPrecio() + "\n");
            catalogoTextArea.append("Tallas Disponibles: " + String.join(", ", producto.getTallasDisponibles()) + "\n\n");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TiendaRopa();
            }
        });
    }
}

