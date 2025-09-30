/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

import conexiones.conexion_BD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Statement;
import universidadulp_grupo5.Alumno;

/**
 *
 * @author Enzo_2
 */
public class AlumnoDAO implements manipuladorGeneral <Alumno> {

    @Override
    public void agregar(Alumno alumno) {
        String sql = "INSERT INTO alumno(dni, email, password, nombre, apellido, fecha_nacimiento, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = conexion_BD.getConnection();
        
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getEmail());
            ps.setString(3, alumno.getPassword());
            ps.setString(4, alumno.getNombre());
            ps.setString(5, alumno.getApellido());
            ps.setDate(6, Date.valueOf(alumno.getFecha_nacimiento()));
            ps.setBoolean(7, alumno.isEstado());
            
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
              
            } else {
                System.out.println("No se pudo agregar al alumno");
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public Alumno buscarPorId(int id) {
        String sql = "SELECT * FROM alumno WHERE id_alumno = ?";
        Connection con = conexion_BD.getConnection();        
        Alumno alumno;
        
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    alumno = new Alumno();
                    alumno.setId_alumno(rs.getInt("id_alumno"));
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setEmail(rs.getString("email"));
                    alumno.setPassword(rs.getString("password"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    alumno.setEstado(rs.getBoolean("estado"));
                }
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return new Alumno();
    }

    @Override
    public List<Alumno> listar() {        
        String sql = "SELECT * FROM alumno";
        Connection con = conexion_BD.getConnection();
        Alumno alumno;
        ArrayList <Alumno> alumnos = new ArrayList<>();        
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try(ResultSet rs=ps.executeQuery()){
               while(rs.next()){
                   alumno = new Alumno();
                   alumno.setId_alumno(rs.getInt("id_alumno"));
                   alumno.setDni(rs.getInt("dni"));
                   alumno.setEmail(rs.getString("email"));
                   alumno.setPassword(rs.getString("password"));
                   alumno.setNombre(rs.getString("nombre"));
                   alumno.setApellido(rs.getString("apellido"));
                   alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                   alumno.setEstado(rs.getBoolean("estado"));
                   alumnos.add(alumno);
               }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Alumno alumno) {
        String sql = "UPDATE alumno SET id_alumno=?, dni=?, email=?, password=?, nombre=?, apellido=?, fecha_nacimiento=?, estado=?";
        Connection con = conexion_BD.getConnection();
       try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, alumno.getId_alumno());
            ps.setInt(2, alumno.getDni());
            ps.setString(3, alumno.getEmail());
            ps.setString(4, alumno.getPassword());
            ps.setString(5, alumno.getNombre());
            ps.setString(6, alumno.getApellido());
            ps.setDate(7, Date.valueOf(alumno.getFecha_nacimiento()));
            ps.setBoolean(8, alumno.isEstado());
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Alumno actualizo ID: " + alumno.getId_alumno());
            } else {
                System.out.println("No se encontro el alumno con ID: " + alumno.getId_alumno());
            } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM inscripcion WHERE id_alumno = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("El alumno con id '" + id +"' se ha eliminado con éxito." );
            } else {
                System.out.println("El alumno con id '" + id +"' no se ha podido eliminar." );
            }
        } catch (SQLException e){
            e.printStackTrace();
        } 
        
    }

}