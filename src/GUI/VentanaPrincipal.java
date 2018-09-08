/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane; // Se me olvido

import Business.ProductoBusiness;
import java.io.IOException;
import Domain.Producto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Capa de inductiva
 * @author adria
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    
    JDesktopPane jDesktopPane;
    JMenuBar jMenuBar;
    ProductoGUI nuevoID; // Principio de polimorfismo
    ProductoGUI busquedaID; // Principio de polimorfismo
    Producto producto;
    ProductoBusiness productoBusiness ;
    JMenu jMenuVentanasInternas;
    JMenuItem ventanaRegistro;
    JMenuItem ventanaBusqueda;
    
    public VentanaPrincipal() {
    
        super();
        try {
                this.productoBusiness = new ProductoBusiness();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(VentanaPrincipal.class.
                getName()).log(Level.SEVERE, null, ex);
        }
        this.setLayout(null);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("MDI (MULTIPLE DOCUMENTO INTERFACE)");
        this.nuevoID = new RegistrarProducto();
        this.busquedaID = new BusquedaIDProducto();
        init();

    } // constructor default
    
    private void init() {
        
        this.jMenuBar = new JMenuBar();
        this.jMenuVentanasInternas = new JMenu("Open Windows");
        this.ventanaRegistro = new JMenuItem("Registro de productos");
        this.ventanaBusqueda = new JMenuItem("Manejo de archivo");
        this.jDesktopPane = new JDesktopPane();
        
        this.ventanaRegistro.addActionListener(this);
        this.ventanaBusqueda.addActionListener(this);
        this.jMenuBar.add(this.jMenuVentanasInternas);
        this.getContentPane().add(this.jDesktopPane);
        this.jMenuVentanasInternas.add(this.ventanaRegistro);
        this.jMenuVentanasInternas.add(this.ventanaBusqueda);
        this.jDesktopPane.add(this.nuevoID);
        this.jDesktopPane.add(this.busquedaID);
        
        this.setJMenuBar(this.jMenuBar);
        this.jDesktopPane.setSize(791, 546);
        this.jDesktopPane.setBackground(Color.WHITE);
        
        
    } // fin init
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ventanaRegistro) {
            
            this.nuevoID.jbtnUno.addActionListener(this);
            this.nuevoID.jbtnDos.addActionListener(this);
            this.nuevoID.setVisible(true);
        
        } else {
            if (e.getSource() == this.ventanaBusqueda) {
                
                this.busquedaID.jbtnUno.addActionListener(this);
                this.busquedaID.jbtnDos.addActionListener(this);
                this.busquedaID.jbtnTres.addActionListener(this);
                this.busquedaID.setVisible(true);
            
            } else {
                if (e.getSource() == this.nuevoID.jbtnUno) {
                    
                    // RegistrarProducto
                    this.nuevoID = new RegistrarProducto();
                    this.jDesktopPane.add(this.nuevoID);
                
                } else {
                    if (e.getSource() == this.busquedaID.jbtnUno) {
                        
                        this.busquedaID = new BusquedaIDProducto();
                        this.jDesktopPane.add(this.busquedaID);
                    
                    } else {
                        if (e.getSource() == this.nuevoID.jbtnDos) {
                            
                            this.producto = new Producto(
                            this.nuevoID.getJtfIDProducto().getText(), 
                            this.nuevoID.getJtfNombreProducto().getText(), 
                            Float.parseFloat(this.nuevoID.
                            getJtfPrecioProducto().getText()));
                            
                            try {
                                
                                this.productoBusiness.addEndRecord(producto);
                                
                            } catch (IOException ex) {
                                
                                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                
                            }
                            try {
                                
                                System.out.println("Producto: " + this.
                                        productoBusiness.getProducto(0).getProductoID()+
                                        " Nombre: " +
                                        this.productoBusiness.getProducto(0).getNombre() +
                                        " Precio: " +
                                        this.productoBusiness.getProducto(0).getPrecio());
                            
                            } catch (IOException ex) {
                               
                                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                           
                            }
                        } else {
                            if (e.getSource() == this.busquedaID.jbtnDos) {
                                
                            } else {
                                if (e.getSource() == this.busquedaID.jbtnTres) {
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    } // fin actionPerformed
    
} //Fin de VentanaPrincipal
