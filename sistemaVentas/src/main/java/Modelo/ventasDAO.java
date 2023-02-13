/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.gbl;
import Controlador.ventasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class ventasDAO {
    
    ResultSet rs;
    int id_cabecera_venta;
    String fecha_venta;
    int id_cliente;
    int id_empleado;
    
    int id_detalle_venta;
    int precio_venta;
    int cantida;
    int id_producto;

    public ventasDAO() {
    }

    public ventasDAO(int id_cabecera_venta, String fecha_venta, int id_cliente, int id_empleado, int id_detalle_venta, int precio_venta, int cantida, int id_producto) {
        this.id_cabecera_venta = id_cabecera_venta;
        this.fecha_venta = fecha_venta;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_detalle_venta = id_detalle_venta;
        this.precio_venta = precio_venta;
        this.cantida = cantida;
        this.id_producto = id_producto;
    }

    public int getId_cabecera_venta() {
        return id_cabecera_venta;
    }

    public void setId_cabecera_venta(int id_cabecera_venta) {
        this.id_cabecera_venta = id_cabecera_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCantida() {
        return cantida;
    }

    public void setCantida(int cantida) {
        this.cantida = cantida;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    public ResultSet cargaVenta() {
        try {
            rs = gbl.cx.cargaVenta("CALL `sp_cargaVenta`();");
        } catch (Exception ex) {
            System.out.println("El error es: " + ex);
        }
        return rs;
    }
    
    public void insertarDatos_cabVenta() {
        try {
            gbl.cx.insertarDatos_cabVenta("CALL `sp_insertarDatos_cabVenta`(?,?,?)", this.getFecha_venta(),
                                                                                this.getId_cliente(),
                                                                                this.getId_empleado());
        } catch (Exception e) {
            System.out.println("El error es: " + e.toString());
        }
    }
    
    public ResultSet ultimoId_cab_venta() throws SQLException {
        try {
            rs = gbl.cx.ultimoId_cab_venta("CALL `sp_ultimoId_cab_venta`;");
            
        } catch (Exception ex) {
            System.out.println("El error es: " + ex);
        }
        return rs;
    }
    
    
    
    
    
}
