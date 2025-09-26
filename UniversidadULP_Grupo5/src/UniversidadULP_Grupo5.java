/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import conexiones.conexion_BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo_2
 */
public class UniversidadULP_Grupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cn = conexion_BD.getConnection();

    }
}
