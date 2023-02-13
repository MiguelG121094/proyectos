package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class conexion {

    public Connection cn = null;
    public Statement st = null;
    public ResultSet rs = null;
    public CallableStatement cs = null;
    
    public conexion(){

            inconectar();

    }
    private void inconectar(){
        try {
            conectar();
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectar() throws Exception {
        String servidor = "localhost";
        String puerto = "3306";
        String usuario = "root";
        String password = ""; // tu contraseÃ±a
        //String password = "admin"; // tu contraseÃ±a
        String driver = "com.mysql.cj.jdbc.Driver";
        String basedatos = "bd_tpmiguelgonzalezlp3"; //nombre de tu DB
        String cadenaconexion = "jdbc:mysql://" + servidor + ":" + puerto + "/" + basedatos;
        Class.forName(driver);
        cn = DriverManager.getConnection(cadenaconexion, usuario, password);
    }

    public ResultSet Consulta(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void Actualizacion(String sql) throws Exception {
        st = cn.createStatement();
        st.executeUpdate(sql);
        
    }

    public void desconectar() throws Exception {
        cn.close();
    }
    
    //PERSONALIZADO CALLABLE
    public void insertarCliente(String sql,String nom1,String nom2,String ape1,String ape2,String cedula){
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, nom1);
            cs.setString(2, nom2);
            cs.setString(3, ape1);
            cs.setString(4, ape2);
            cs.setString(5, cedula);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());;
        }
    }
    public ResultSet buscarDatos(String sql, int id_persona) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_persona);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return rs;
    }
    
    //**
    public ResultSet cargaPersonas_2(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    
    
    //DESDE ACA PARA EL PROYECTO
    public ResultSet cargaArticulos(String sql) throws Exception{
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public void eliminarArticulo(String sql, int id_articulo){
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_articulo);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } 
    }
    
    public void insertarArticulo(String sql,String nombre,String marca, int id_deposito){
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, nombre);
            cs.setString(2, marca);
            cs.setInt(3, id_deposito);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public ResultSet cargaDepositos(String sql){
        try {
            cs = cn.prepareCall(sql);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return rs;
    }
    
    
}
