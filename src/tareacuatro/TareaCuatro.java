/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareacuatro;

import GUI.VentanaPrincipal;
import javax.swing.JFrame;

/**
 * Clonado
 * @author adria
 */
public class TareaCuatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            VentanaPrincipal ventanaPrincipal =new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        
        }

    } // main
    
} // END RAFMemoriaCpUDisco
