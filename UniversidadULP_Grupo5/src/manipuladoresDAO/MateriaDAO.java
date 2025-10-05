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
import universidadulp_grupo5.Materia;

/**
 *
 * @author Enzo_2
 */
public class MateriaDAO implements manipuladorGeneral<Materia> {

    @Override
    public void agregar(Materia materia) {
        String sql = "INSERT INTO materia(nombre, descripcion, codigo_materia, estado) VALUES (?, ?, ?, ?)";
        Connection con = conexion_BD.getConnection();

        try (PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1,materia.getNombre());
            ps.setString(2,materia.getDescripcion());
            ps.setString(3,materia.getCodigo_materia());
            ps.setBoolean(4,materia.isEstado());

            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));
            } else {
                System.out.println("no se pudo agregar la materia");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Materia buscarPorId(int id) {
        String sql = "SELECT * FROM materia WHERE id_materia = ?";
        Connection con = conexion_BD.getConnection();
        Materia materia = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    materia = new Materia();
                    materia.setId_materia(rs.getInt("id_materia"));
                    materia.setNombre(rs.getNString("nombre"));
                    materia.setDescripcion(rs.getNString("descripcion"));
                    materia.setCodigo_materia(rs.getNString("codigo_materia"));
                    materia.setEstado(rs.getBoolean("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materia;
    }

    @Override
    public List<Materia> listar() {
        String sql = "SELECT * FROM materia";
        Connection con = conexion_BD.getConnection();
        ArrayList<Materia> listaMaterias = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Materia materia = new Materia();
                    materia.setId_materia(rs.getInt("id_materia"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setDescripcion(rs.getString("descripcion"));
                    materia.setCodigo_materia(rs.getString("codigo_materia"));
                    materia.setEstado(rs.getBoolean("estado"));
                    listaMaterias.add(materia);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return listaMaterias;

    }

    @Override
    public void actualizar(Materia materia) {
        String sql = "UPDATE materia SET nombre = ? , descripcion = ? ,codigo_materia = ? , estado = ? where id_materia = ? ";
        Connection con = conexion_BD.getConnection();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getDescripcion());
            ps.setString(3, materia.getCodigo_materia());
            ps.setBoolean(4, materia.isEstado());
            ps.setInt(5, materia.getId_materia());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Materia modificada con id" + materia.getId_materia());
            } else {
                System.out.println("No se encontro la materia con el id " + materia.getId_materia());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM materia WHERE id_materia = ?";
        Connection con = conexion_BD.getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("se ha eliminado la materia seleccionada con exito " + id);
            } else {
                System.out.println("no se ha encontrado la materia solicitada " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Materia> listarPorAlumno(int id) {
        String sql = "SELECT i.id_materia,  m.nombre, m.descripcion, m.codigo_materia, m.estado "
                + "FROM inscripcion i JOIN materia m ON m.id_materia = i.id_materia WHERE id_alumno = ?";
        Connection con = conexion_BD.getConnection();
        Materia materia = null;
        ArrayList<Materia> materias = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    materia = new Materia();
                    materia.setId_materia(rs.getInt("i.id_materia"));
                    materia.setNombre(rs.getString("m.nombre"));
                    materia.setDescripcion(rs.getString("m.descripcion"));
                    materia.setCodigo_materia(rs.getString("m.codigo_materia"));
                    materia.setEstado(rs.getBoolean("m.estado"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materias;
    }
    
    public void actualizarPorID(int id, Materia materia) {
        String sql = "UPDATE materia SET nombre = ? , descripcion = ? ,codigo_materia = ? , estado = ? where id_materia = ? ";
        Connection con = conexion_BD.getConnection();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getDescripcion());
            ps.setString(3, materia.getCodigo_materia());
            ps.setBoolean(4, materia.isEstado());
            ps.setInt(5, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Materia modificada con id" + materia.getId_materia());
            } else {
                System.out.println("No se encontro la materia con el id " + materia.getId_materia());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    public void darBaja(int id){
        String sql = "UPDATE materia SET estado = false WHERE id_materia = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Se ha actualiza el estado a inactivo de la materia con el id " + id);
            } else {
                System.out.println("No se ha encontrado la materia con id " + id);
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
        
        public void darAlta(int id){
        String sql = "UPDATE materia SET estado = true WHERE id_materia = ?";
        Connection con = conexion_BD.getConnection();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if(filas > 0){
                System.out.println("Se ha actualiza el estado a activo de la materia con el id " + id);
            } else {
                System.out.println("No se ha encontrado la materia con id " + id);
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
