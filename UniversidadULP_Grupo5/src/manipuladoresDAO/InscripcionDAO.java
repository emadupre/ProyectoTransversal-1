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
import universidadulp_grupo5.Alumno;
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
        
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, inscripcion.getId_usuario());
            ps.setInt(2, inscripcion.getId_materia());
            ps.setBoolean(3, inscripcion.isEstado());
            
            ps.executeUpdate();
            
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
            ps.executeQuery();
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
    public List<Inscripcion> listar(int id) {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Inscripcion inscripcion) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }
    
}
