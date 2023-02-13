/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

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

    public Connection conexion  = null;
    
    public Statement statement;
    public ResultSet resulSet;
    
    
    public boolean conectar(){
        System.out.println("Se ejecuto el metodo conectar");
        try {
                Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al ejecutar el driver de PostgreSQL: " + ex);
        }
        
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/seguridad", 
                    "postgres", "adolfo94");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }
    
    
    
    
    public static void main(String[] args) {
        conexion con = new conexion();
        con.conectar();
    }
    
}
