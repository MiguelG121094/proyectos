/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    //CRUD
    public List listar() {
        String sql = "CALL `sp_cargarProducto`";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto produc = new Producto();
                produc.setId(rs.getInt(1));
                produc.setDescripcion(rs.getString(2));
                produc.setPrecio_compra(rs.getInt(3));
                produc.setPrecio_venta(rs.getInt(4));
                produc.setCant_minima(rs.getInt(5));
                lista.add(produc);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int insertar(Producto produc) {
        String sql = "insert into producto(descripcion, pro_precio_compra, pro_precio_venta, cantidad_minima) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, produc.getDescripcion());
            ps.setInt(2, produc.getPrecio_compra());
            ps.setInt(3, produc.getPrecio_venta());
            ps.setInt(4, produc.getCant_minima());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Producto listar_id(int id) {
        Producto produc = new Producto();
        String sql = "select * from producto where id_producto ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                produc.setId(rs.getInt("id_producto"));
                produc.setDescripcion(rs.getString(2));
                produc.setPrecio_compra(rs.getInt(3));
                produc.setPrecio_venta(rs.getInt(4));
                produc.setCant_minima(rs.getInt(5));

            }

        } catch (Exception e) {
        }
        return produc;
    }

    public int editar(Producto produc) {
        String sql = "update producto set descripcion=?, pro_precio_compra=?, pro_precio_venta=?, cantidad_minima=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, produc.getDescripcion());
            ps.setInt(2, produc.getPrecio_compra());
            ps.setInt(3, produc.getPrecio_venta());
            ps.setInt(4, produc.getCant_minima());
            ps.setInt(5, produc.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void borrar(int id) {
        String sql = "delete from producto where id_producto = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
    
}
