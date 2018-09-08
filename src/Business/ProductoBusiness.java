/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ProductoData;
import Domain.Producto;
import java.io.IOException;

/**
 *
 * @author adria
 */
public class ProductoBusiness {
    
    ProductoData productoData;
    
    public ProductoBusiness() throws IOException{
    
        productoData = new ProductoData();
    
    } // constructor
    
    public boolean addEndRecord (Producto producto) throws IOException {
    
        return this.productoData.addEndRecord(producto);

    } // addEndRecord
    
    public Producto getProducto(int position) throws IOException {

        return this.productoData.getProducto(position);

    }
} // Fin PersonBusiness
