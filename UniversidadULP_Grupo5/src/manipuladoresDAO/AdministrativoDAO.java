/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

import conexiones.conexion_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Statement;
import universidadulp_grupo5.Administrativo;



/**
 *
 * @author Enzo_2
 */
public class AdministrativoDAO implements manipuladorGeneral <Administrativo> {

    @Override
    public void agregar(Administrativo administrativo) {
          String sql = "INSERT INTO administrativo(dni, nombre, apellido, email, password, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = conexion_BD.getConnection();
        
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, administrativo.getDni());
            ps.setString(2, administrativo.getNombre());
            ps.setString(3, administrativo.getApellido());
            ps.setString(4, administrativo.getEmail());
            ps.setString(5, administrativo.getPassword());
            ps.setLong(6, administrativo.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                administrativo.setId_administrativo(1);
            } else {
                System.out.println("No se pudo crear administrativo");
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

        
    
    @Override
    public Administrativo buscarPorId(int id) {

   String sql = "SELECT * FROM administrativo WHERE id_administrativo = ?";
        Connection con = conexion_BD.getConnection();
       Administrativo administrativo = null;
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    administrativo = new Administrativo();
                    administrativo.setId_administrativo(rs.getInt("id_administrativo"));
                    administrativo.setDni(rs.getInt("dni"));
                    administrativo.setApellido(rs.getString("nombre"));
                    administrativo.setApellido(rs.getString("apellido"));
                    administrativo.setEmail(rs.getString("email"));
                    administrativo.setPassword(rs.getString("password"));
                    administrativo.setTelefono(rs.getLong("telefono"));
                }
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return administrativo;
       
    }


    @Override
    public List<Administrativo> listar(int id) {
        String sql = " Select * FROM adminstrativo where id_administrativo =?";
        Connection con = conexion_BD.getConnection();
        Administrativo administrativo = null;
        ArrayList<Administrativo> administrativos = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    administrativo = new Administrativo();
                    administrativo.setId_administrativo(rs.getInt("id_administrativo"));
                    administrativo.setDni(rs.getInt("dni"));
                    administrativo.setApellido(rs.getString("nombre"));
                    administrativo.setApellido(rs.getString("apellido"));
                    administrativo.setEmail(rs.getString("email"));
                    administrativo.setPassword(rs.getString("password"));
                    administrativo.setTelefono(rs.getLong("telefono"));
            }
        } } catch (SQLException e){
            e.printStackTrace();
        }
        return administrativos;
    }

    @Override
    public void actualizar(Administrativo administrativo) {
        String sql = "UPDATE administrativo SET  dni = ?, nombre = ?, apellido = ?, email = ?; password = ?; telefono = ? WHERE id_admnistrativo= ?";
        Connection con = conexion_BD.getConnection();
        try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, administrativo.getId_administrativo());
            ps.setInt(2, administrativo.getDni());
            ps.setString(3, administrativo.getNombre());
            ps.setString(4, administrativo.getApellido());
            ps.setString(5, administrativo.getEmail());
            ps.setString(6, administrativo.getPassword());
            ps.setLong(7, administrativo.getTelefono());
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("actulización realizada con ID: " + administrativo.getId_administrativo());
            } else {
                System.out.println("No se encontró administrativo con ID: " + administrativo.getId_administrativo());
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    

    @Override
    public void eliminar(int id) {


 String sql = "DELETE FROM administrativo WHERE id_administrativo = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Se ha eliminado administrativo exitosamente con id " + id);
            } else {
                System.out.println("No se ha encontrado administrativo con el id " + id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
        
}



