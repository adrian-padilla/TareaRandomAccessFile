/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Producto;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author adria
 */
public class ProductoData {
    private RandomAccessFile randomAccessFile; //
    private int regsQuantity; //
    private int regsSize; //
    private String myFilePath; //

    public ProductoData() throws IOException {
        this.myFilePath = "producto.dat";
        File file = new File(this.myFilePath);
        start(file);
    } // constructor
    
    private void start(File file) throws IOException {
        this.myFilePath = file.getPath();
        this.regsSize = 140;
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + " is an invalid file (001)");
        } else {
            this.randomAccessFile = new RandomAccessFile(file, "rw");
            this.regsQuantity = (int)Math.ceil(
                    this.randomAccessFile.length()/this.regsSize
            );
        } 
           // if-else
    } // start
    public int fileSize() {
        return this.regsQuantity;
    } // FileSze
    public boolean putValue(int position, Producto producto) throws IOException{
        if (position >= 0 && position <= regsQuantity) {
            if (producto.size() > this.regsSize) {
                return false;
            } else {
                this.randomAccessFile.seek(position*this.regsSize);
                this.randomAccessFile.writeUTF(producto.getProductoID());
                this.randomAccessFile.writeUTF(producto.getNombre());
                this.randomAccessFile.writeFloat(producto.getPrecio());
                return true;
            } // if-else
        } // position
        return false;
    }
    
    public boolean addEndRecord (Producto producto) throws IOException {
        
        if (this.putValue(this.regsQuantity, producto)) {
            ++regsQuantity;
//     posincrementa       regsQuantity++;
            return true;
        } //
        
        return false;
    }
    public Producto getProducto(int position) throws IOException {
        if (position >= 0 && position <= regsQuantity) {
            this.randomAccessFile.seek(position*this.regsSize);
            Producto producto = new Producto();
            producto.setProductoID(this.randomAccessFile.readUTF());
            producto.setNombre(this.randomAccessFile.readUTF());
            producto.setPrecio(this.randomAccessFile.readFloat());
            if (producto.getProductoID().equals("deleted")) {
                return null;
            } else {
                return producto;
            } // if-else
        }
        return null;
    }
} // END PersonData
