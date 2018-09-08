/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author adria
 */
public class ProductoGUI extends JInternalFrame {
    
    public JButton jbtnUno;
    public JButton jbtnDos;
    public JButton jbtnTres;
    
    private JTextField jtfIDProducto;;
    private JTextField jtfNombreProducto;
    private JTextField jtfPrecioProducto;
    
    public JLabel jlEspecializacion;
    public JLabel jlIDProducto;
    public JLabel jlNombreProducto;
    public JLabel jlPrecioProducto;
    
    Font fTahoma18;
    
    public ProductoGUI() {
        
        super();
        this.setLayout(null);
        this.setSize(791 , 546);
        this.setTitle("Colección");
        this.init();
    
    } // Contructor default
    
    private void init() {
    
        this.jbtnUno = new JButton();
        this.jbtnDos = new JButton();
        this.jbtnTres = new JButton();
        this.setJtfIDProducto(new JTextField());
        this.setJtfNombreProducto(new JTextField());
        this.setJtfPrecioProducto(new JTextField());
        this.jlEspecializacion = new JLabel("Registrar Producto");
        this.jlIDProducto = new JLabel("ID Producto: ");
        this.jlNombreProducto = new JLabel("Nombre: ");
        this.jlPrecioProducto = new JLabel("Precio: ");
        this.fTahoma18 = new Font("Tahoma", Font.TYPE1_FONT, 18); // Fuente
        
        this.jbtnUno.setBounds(60, 400, 160, 30);
        this.jbtnDos.setBounds(290, 400, 160, 30);
        this.jbtnTres.setBounds(520, 400, 160, 30);
        this.getJtfIDProducto().setBounds(220, 110, 400, 30);
        this.getJtfNombreProducto().setBounds(220, 190, 400, 30);
        this.getJtfPrecioProducto().setBounds(220, 270, 400, 30);
        this.jlEspecializacion.setBounds(50, 20, 500, 50);
        this.jlIDProducto.setBounds(70, 110, 160, 30);
        this.jlNombreProducto.setBounds(70, 190, 160, 30);
        this.jlPrecioProducto.setBounds(70, 270, 160, 30);
        
        this.jlEspecializacion.setFont(this.fTahoma18);
        
        this.add(this.jbtnUno);
        this.add(this.jbtnDos);
        this.add(this.jbtnTres);
        this.add(this.getJtfIDProducto());
        this.add(this.getJtfNombreProducto());
        this.add(this.getJtfPrecioProducto());
        this.add(this.jlEspecializacion);
        this.add(this.jlIDProducto);
        this.add(this.jlNombreProducto);
        this.add(this.jlPrecioProducto);
        
        this.jbtnUno.addActionListener((ActionEvent ae) -> {
            dispose();
        });
        this.jbtnDos.addActionListener((ActionEvent ae) -> {
        });
        this.jbtnTres.addActionListener((ActionEvent ae) -> {
        });
    
    } // init

    /**
     * @return the jtfIDProducto
     */
    public JTextField getJtfIDProducto() {
        return jtfIDProducto;
    }

    /**
     * @param jtfIDProducto the jtfIDProducto to set
     */
    public void setJtfIDProducto(JTextField jtfIDProducto) {
        this.jtfIDProducto = jtfIDProducto;
    }

    /**
     * @return the jtfNombreProducto
     */
    public JTextField getJtfNombreProducto() {
        return jtfNombreProducto;
    }

    /**
     * @param jtfNombreProducto the jtfNombreProducto to set
     */
    public void setJtfNombreProducto(JTextField jtfNombreProducto) {
        this.jtfNombreProducto = jtfNombreProducto;
    }

    /**
     * @return the jtfPrecioProducto
     */
    public JTextField getJtfPrecioProducto() {
        return jtfPrecioProducto;
    }

    /**
     * @param jtfPrecioProducto the jtfPrecioProducto to set
     */
    public void setJtfPrecioProducto(JTextField jtfPrecioProducto) {
        this.jtfPrecioProducto = jtfPrecioProducto;
    }
    
} // Fin clase RegistrarIDProducto
