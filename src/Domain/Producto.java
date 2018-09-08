/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author adria
 */
public class Producto {
    private String productoID;
    private String nombre;
    private float precio;
    public Producto() {
        this.productoID = "";
        this.nombre = "";
        this.precio = 0;
    }

    public Producto(String productoID, String nombre, float precio ) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int size() {
        return this.productoID.length() * 2 + this.nombre.length()*2 + 4;
    }

    public String getProductoID() {
        return productoID;
    }

    public void setProductoID(String productoID) {
        this.productoID = productoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
} // END producto
