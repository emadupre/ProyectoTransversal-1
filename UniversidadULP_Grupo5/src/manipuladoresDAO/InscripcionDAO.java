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
import universidadulp_grupo5.Inscripcion;

/**
 *
 * @author Enzo_2
 */
public class InscripcionDAO implements manipuladorGeneral <Inscripcion> {

    @Override
    public void agregar(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion(id_alumno, id_materia, estado) VALUES (?, ?, ?)";
        Connection con = conexion_BD.getConnection();
        
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, inscripcion.getId_usuario());
            ps.setInt(2, inscripcion.getId_materia());
            ps.setBoolean(3, inscripcion.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                inscripcion.setId_inscripcion(rs.getInt(1));
            } else {
                System.out.println("No se pudo crear la inscripción");
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Inscripcion buscarPorId(int id) {
        String sql = "SELECT * FROM inscripcion WHERE id_inscripcion = ?";
        Connection con = conexion_BD.getConnection();
        Inscripcion inscripcion = null;
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    inscripcion = new Inscripcion();
                    inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
                    inscripcion.setId_usuario(rs.getInt("id_alumno"));
                    inscripcion.setId_materia(rs.getInt("id_materia"));
                    inscripcion.setEstado(rs.getBoolean("estado"));
                }
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        } 
        return inscripcion;

    }

    @Override
    public List<Inscripcion> listar() {
        String sql  = "SELECT * FROM inscripcion";
        Connection con = conexion_BD.getConnection();
        Inscripcion inscripcion = null;
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        try (PreparedStatement ps = con.prepareStatement(sql)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    inscripcion = new Inscripcion();
                    inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
                    inscripcion.setId_materia(rs.getInt("id_materia"));
                    inscripcion.setId_usuario(rs.getInt("id_alumno"));
                    inscripcion.setEstado(rs.getBoolean("estado"));
                    inscripciones.add(inscripcion);
                }
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        } 
        return inscripciones;
    }

    @Override
    public void actualizar(Inscripcion inscripcion) {
        String sql = "UPDATE inscripcion SET id_alumno, = ?, id_materia = ?, estado = ? WHERE id_inscripcion = ?";
        Connection con = conexion_BD.getConnection();
        try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, inscripcion.getId_usuario());
            ps.setInt(2, inscripcion.getId_materia());
            ps.setBoolean(3, inscripcion.isEstado());
            ps.setInt(4, inscripcion.getId_inscripcion());
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Inscripcion realizada con ID: " + inscripcion.getId_inscripcion());
            } else {
                System.out.println("No se encontro la inscripcion con ID: " + inscripcion.getId_inscripcion());
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        } 
        
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM inscripcion WHERE id_inscripcion = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Se ha eliminado la inscripcion exitosamente con id " + id);
            } else {
                System.out.println("No se ha encontrado la inscripcion con el id " + id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public List<Inscripcion> listarInscripcionesPorAlumno(int id) {
        String sql  = "SELECT * FROM inscripcion WHERE id_alumno = ?";
        Connection con = conexion_BD.getConnection();
        Inscripcion inscripcion = null;
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    inscripcion = new Inscripcion();
                    inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
                    inscripcion.setId_materia(rs.getInt("id_materia"));
                    inscripcion.setId_usuario(rs.getInt("id_alumno"));
                    inscripcion.setEstado(rs.getBoolean("estado"));
                    inscripciones.add(inscripcion);
                }
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        } 
        return inscripciones;
    }
    
    public void darseBaja(int id){
        String sql = "UPDATE inscripcion SET estado = false WHERE id_inscripcion = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Se ha actualiza el estado a inactivo de la inscripcion con el id " + id);
            } else {
                System.out.println("No se ha encontrado la inscripcion con id " + id);
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void darseAlta(int id){
        String sql = "UPDATE inscripcion SET estado = true WHERE id_inscripcion = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Se ha actualiza el estado a activo de la inscripcion con el id " + id);
            } else {
                System.out.println("No se ha encontrado la inscripcion con id " + id);
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        } 
    }
}
