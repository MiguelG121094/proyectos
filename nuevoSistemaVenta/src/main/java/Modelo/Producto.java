/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Miguel
 */
public class Producto {
    int id;
    String descripcion;
    int precio_compra;
    int precio_venta;
    int cant_minima;

    public Producto() {
    }

    public Producto(int id, String descripcion, int precio_compra, int precio_venta, int cant_minima) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cant_minima = cant_minima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCant_minima() {
        return cant_minima;
    }

    public void setCant_minima(int cant_minima) {
        this.cant_minima = cant_minima;
    }
    
    
    
    
    
    
}
