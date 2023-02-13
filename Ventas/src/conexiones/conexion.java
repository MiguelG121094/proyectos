/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class conexion {
        Connection conexion = null;
        
        public Statement statement;
        
        public ResultSet resulSet;
        
        
    public void traerDatos(){
        
            try {
                statement = conexion.createStatement();
                resulSet = statement.executeQuery("select * from cliente");
                
                //el while es para que recorra  el resulset hasta que traiga todo
                //lo que está en el query ejecutado
                while (resulSet.next()) {
                    System.out.println("Ruc: " + resulSet.getString("ruc"));
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public void conectar(){
        System.out.println("Aqui se ejecuto el metodo conectar");
        try {
                Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al ejecutar el driver de PostgreSQL: " + ex);
        }
        
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ventas", 
                    "postgres", "adolfo94");
            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args) {
        conexion con = new conexion();
        
        con.conectar();
        con.traerDatos();
        
        
    }
    
}
