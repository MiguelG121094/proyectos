package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class conexion_mysql {

    public Connection cn = null;
    public Statement st = null;
    public ResultSet rs = null;
    public CallableStatement cs = null;
    
    public conexion_mysql(){

            inconectar();

    }
    private void inconectar(){
        try {
            conectar();
        } catch (Exception ex) {
            Logger.getLogger(conexion_mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectar() throws Exception {
        String servidor = "localhost";
        String puerto = "3306";
        String usuario = "root";
        String password = ""; // tu contraseÃ±a
        //String password = "admin"; // tu contraseÃ±a
        String driver = "com.mysql.cj.jdbc.Driver";
        String basedatos = "bd_personas"; //nombre de tu DB
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
    //METODOS PARA PERSONAS
    public ResultSet cargaPersonas(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public void insertarPersonas(String sql,String accion,String cedula,String nombre,String apellido, int id_ciudad){
        try {
            cs = cn.prepareCall(sql); // el cs es la instancia del callable statement que es la libreria y hace que se inserten los datos y permanezcan dentro del sistema
            cs.setString(1, accion);
            cs.setString(2, cedula);
            cs.setString(3, nombre);
            cs.setString(4, apellido);
            cs.setInt(5, id_ciudad);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarPersona(String sql,int id_persona){
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_persona);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public ResultSet cargaPersonas_id(String sql, int id_persona) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_persona);
            rs = cs.executeQuery();//cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return rs;
    }
    
    public void editarPersona(String sql,int id_persona, String cedula, String nombre, String apellido){
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_persona);
            cs.setString(2, cedula);
            cs.setString(3, nombre);
            cs.setString(4, apellido);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public ResultSet cargaCiudades(String sql) {
        try {
            cs = cn.prepareCall(sql);
            //cs.setInt(1, id_persona);
            rs = cs.executeQuery();//cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return rs;
    }
    
    public Connection conectar_reporte() throws Exception{
        String servidor = "localhost";
        String puerto = "3306";
        String usuario = "root";
        String password = ""; // tu contraseÃ±a
        //String password = "admin"; // tu contraseÃ±a
        String driver = "com.mysql.cj.jdbc.Driver";
        String basedatos = "bd_personas"; //nombre de tu DB
        String cadenaconexion = "jdbc:mysql://" + servidor + ":" + puerto + "/" + basedatos;
        Class.forName(driver);
        cn = DriverManager.getConnection(cadenaconexion, usuario, password);
        
        return cn;
    }
    
    
    
    
    
    //METODOS PARA CIUDAD
    public ResultSet cargaCiudades2(String sql) throws Exception {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public void insertarCiudad(String sql,String descripcion){
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, descripcion);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarCiudad(String sql,int id_ciudad){
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_ciudad);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public ResultSet cargaCiudad_id(String sql, int id_ciudad) {
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_ciudad);
            rs = cs.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return rs;
    }
    
    public void editarCiudad(String sql, int id_ciudad, String descripcion){
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, id_ciudad);
            cs.setString(2, descripcion);
            cs.execute();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
