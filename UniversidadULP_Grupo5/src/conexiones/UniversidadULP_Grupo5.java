/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

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

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection Practico_integrador = DriverManager.getConnection("jdbc:mariadb://localhost/********", "root", "");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error al cargar la base de datos ");
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "no se puede establecer conexion");
        }

    }
}
