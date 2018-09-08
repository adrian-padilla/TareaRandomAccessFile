/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 * Forma1
 * @author adria
 */
public class RegistrarProducto extends ProductoGUI {
    
    public RegistrarProducto() {
        
        super();
        this.setTitle("Crear Producto");
        this.jbtnUno.setBounds(180, 400, 160, 30);
        this.jbtnDos.setBounds(450, 400, 160, 30);
        this.jbtnTres.setVisible(false);
        this.jbtnUno.setText("Cancelar");
        this.jbtnDos.setText("Registrar");
        
    }
    
}