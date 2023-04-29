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
public class ProveedorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    //CRUD
    public List listar() {
        String sql = "CALL `sp_cargarProveedor`";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setCi(rs.getInt(4));
                p.setDireccion(rs.getString(5));
                p.setTelefono(rs.getString(6));
                p.setRuc(rs.getString(7));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int insertar(Proveedor p) {
        String sql = "insert into proveedor(nombre, apellido, ci, direccion, telefono, ruc) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getCi());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getRuc());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public Proveedor listar_id(int id) {
        Proveedor p = new Proveedor();
        String sql = "select * from proveedor where id_proveedor ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setCi(rs.getInt(4));
                p.setDireccion(rs.getString(5));
                p.setTelefono(rs.getString(6));
                p.setRuc(rs.getString(7));

            }

        } catch (Exception e) {
        }
        return p;
    }

    public int editar(Proveedor p) {
        String sql = "update proveedor set nombre=?, apellido=?, ci=?, direccion=?, telefono=?, ruc=? where id_proveedor=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getCi());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getRuc());
            ps.setInt(7, p.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void borrar(int id) {
        String sql = "delete from proveedor where id_proveedor = "+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
    
}
