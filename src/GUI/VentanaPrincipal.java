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
import javax.swing.JSeparator;

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
    JMenu jMenuMs;
    JMenuItem ventanaRegistro;
    JMenuItem ventanaBusqueda;
    JMenuItem jMenuItemActualizar;
    JMenuItem jMenuItemTerminar;
    JSeparator jSeparadorRs;
    JSeparator jSeparatorMs;
    String buscarID;
    
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
        this.jMenuMs = new JMenu("     ≡     ");
        this.ventanaRegistro = new JMenuItem("Registro de productos");
        this.ventanaBusqueda = new JMenuItem("Manejo de archivo");
        this.jMenuItemActualizar = new JMenuItem("Realizar acción sobre productos");
        this.jMenuItemTerminar = new JMenuItem("Realizar cierre");
        this.jSeparadorRs = new JSeparator(0);
        this.jSeparatorMs = new JSeparator(0);
        this.jDesktopPane = new JDesktopPane();
        
        this.ventanaRegistro.addActionListener(this);
        this.ventanaBusqueda.addActionListener(this);
        this.jMenuItemActualizar.addActionListener(this);
        this.jMenuItemTerminar.addActionListener(this);
        this.jMenuItemTerminar.addActionListener(this);
        this.jMenuBar.add(this.jMenuVentanasInternas);
        this.getContentPane().add(this.jDesktopPane);
        this.jMenuVentanasInternas.add(this.ventanaRegistro);
        this.jMenuVentanasInternas.add(this.ventanaBusqueda);
        this.jMenuVentanasInternas.add(this.jSeparadorRs);
        this.jMenuVentanasInternas.add(this.jMenuMs);
        this.jMenuMs.add(this.jMenuItemActualizar);
        this.jMenuVentanasInternas.add(this.jSeparatorMs);
        this.jMenuVentanasInternas.add(this.jMenuItemTerminar);
        this.jDesktopPane.add(this.nuevoID);
        this.jDesktopPane.add(this.busquedaID);
        
        this.setJMenuBar(this.jMenuBar);
        this.jDesktopPane.setSize(800, 600);
        this.jDesktopPane.setBackground(Color.WHITE);
        
        
    } // fin init
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.ventanaRegistro) {
            
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
                                
                                Logger.getLogger(VentanaPrincipal.class.
                                getName()).log(Level.SEVERE, null, ex);
                                
                            }
                            try {
                                
                                System.out.println("Producto: " + this.
                                productoBusiness.getProducto(0).getProductoID()+
                                " Nombre: " +
                                this.productoBusiness.getProducto(0).getNombre() +
                                " Precio: " +
                                this.productoBusiness.getProducto(0).getPrecio());
                            
                            } catch (IOException ex) {
                               
                                Logger.getLogger(VentanaPrincipal.class.
                                getName()).log(Level.SEVERE, null, ex);
                           
                            } catch (NullPointerException nex) {
                                nex.getSuppressed();
                            }
                        } else {
                            if (e.getSource() == this.busquedaID.jbtnDos) {
                                
                                
                                
                            } else {
                                if (e.getSource() == this.busquedaID.jbtnTres) {
                                    
//                                    producto
                                    if (JOptionPane.showConfirmDialog(this, 
                                    "Remover el producto ", "Confirmar acción ",
                                    JOptionPane.WARNING_MESSAGE) == 0) {
                                        
                                    } else {
                                       
                                        System.out.println("No se eliminó");
                                    
                                    }
                                
                                } else {
                                    if (e.getSource() == this.jMenuItemActualizar) {
                                        
                                        String productoID = new String(JOptionPane.
                                        showInputDialog(this, "¿Ingrese el ID del"
                                        + " producto que busca por favor?"));
                                        producto = new Producto(productoID, "", 0);
                                        
                                        try {
                                            if (productoBusiness.isDeleted(producto)) {
                                                
                                                System.out.
                                                        println("El producto ha sido encontrado");
                                                
                                            } else {
                                                
                                                System.out.
                                                        println("El producto salió de vigencia");
                                                
                                            }
                                        } catch (IOException ex) {
                                            Logger.getLogger(VentanaPrincipal.class.
                                            getName()).log(Level.SEVERE, null, ex);
                                        }
                                    
                                    } else {
                                        if (e.getSource() == this.jMenuItemTerminar) {
                                        
                                            System.exit(0);
                                        
                                        }
                                    } 
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    } // fin actionPerformed
    
} //Fin de VentanaPrincipal
