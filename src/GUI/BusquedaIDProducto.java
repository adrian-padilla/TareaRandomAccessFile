/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 * Forma2
 * @author adria
 */
public class BusquedaIDProducto extends ProductoGUI {
    
    public BusquedaIDProducto() {
        super();
        this.setTitle("Controlar Producto");
        this.jbtnUno.setText("Cancelar");
        this.jbtnDos.setText("Actualizar");
        this.jbtnTres.setText("Eliminar");
        this.jlEspecializacion.setText("Actualizar Producto");
        init();
    }
    private void init() {
    }
}
