/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose Bossa
 */
public class conexion_BD {
    
    private static Connection con = null;
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://localhost/universidadpropio";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){
        try {
            if(con == null){
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            }     
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    
    public static void closeConnection(){
        try{
            if(con != null){
                con.close();
                con = null;
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
        
}
    
