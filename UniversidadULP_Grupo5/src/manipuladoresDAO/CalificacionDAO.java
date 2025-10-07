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
import java.util.HashMap;
import java.util.List;
import org.mariadb.jdbc.Statement;
import universidadulp_grupo5.Calificacion;

/**
 *
 * @author Enzo_2
 */
public class CalificacionDAO implements manipuladorGeneral<Calificacion> {

    @Override
    public void agregar(Calificacion calificacion) {
        String sql = "INSERT INTO calificaciones (id_inscripcion, id_administrativo, calificacion) VALUE (?,?,?)";
        Connection con = conexion_BD.getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, calificacion.getId_inscripcion());
            ps.setInt(2, calificacion.getId_calificacion());
            ps.setDouble(3, calificacion.getCalificacion());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                calificacion.setCalificacion(rs.getInt(1));
                System.out.println("calificacion registrada: " + calificacion.getId_calificacion());
            } else {
                System.out.println("no se pudo registrarse correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Calificacion buscarPorId(int id) {
        String sql = "SELECT * FROM calificaciones WHERE id_calificacion = ?";
        Connection con = conexion_BD.getConnection();
        Calificacion calificacion = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    calificacion = new Calificacion();
                    calificacion.setId_inscripcion(rs.getInt("id_inscripcion"));
                    calificacion.setId_administrativo(rs.getInt("id_administrativo"));
                    calificacion.setId_calificacion(rs.getInt("id_calificacion"));
                    calificacion.setCalificacion(rs.getDouble("calificacion"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calificacion;

    }

    public HashMap<Integer, ArrayList<Calificacion>> IDinscripcionXCalificacionesPorIdAlumno(int id_alumno) {
        String sql = "SELECT i.id_inscripcion AS idInscripcionCali, c.id_administrativo, c.calificacion "
                + "FROM inscripcion i JOIN calificaciones c ON i.id_inscripcion = c.id_inscripcion "
                + "WHERE i.id_alumno = ?";
        Connection con = conexion_BD.getConnection();
        HashMap<Integer, ArrayList<Calificacion>> listaCalificaciones = new HashMap<>();
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_alumno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                        int idIns = rs.getInt("idInscripcionCali");
                        Calificacion cal = new Calificacion();
                        cal.setId_inscripcion(idIns);
                        cal.setId_administrativo(rs.getInt("c.id_administrativo"));
                        cal.setCalificacion(rs.getDouble("c.calificacion"));
                        
                        ArrayList<Calificacion> calificacionPorMateria;
                        if(listaCalificaciones.containsKey(idIns)){
                            calificacionPorMateria = listaCalificaciones.get(idIns);
                        } else {
                            calificacionPorMateria = new ArrayList<>();
                            listaCalificaciones.put(idIns, calificacionPorMateria);
                        }
                        
                        calificacionPorMateria.add(cal);
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCalificaciones;
    }

    public List<Calificacion> listarPorIdInscripcion(int id_inscripcion) {
        String sql = "SELECT * FROM calificaciones WHERE id_inscripcion = ?";
        Connection con = conexion_BD.getConnection();
        Calificacion calificacion = null;
        ArrayList<Calificacion> calificaciones = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_inscripcion);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    calificacion = new Calificacion();
                    calificacion.setId_inscripcion(rs.getInt("id_inscripcion"));
                    calificacion.setId_administrativo(rs.getInt("id_administrativo"));
                    calificacion.setId_calificacion(rs.getInt("id_calificacion"));
                    calificacion.setCalificacion(rs.getDouble("calificacion"));
                    calificaciones.add(calificacion);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calificaciones;
    }

    @Override
    public void actualizar(Calificacion calificacion) {
        String sql = "UPDATE calificaciones SET id_inscripcion, = ?, id_administrativo = ?, calificacion = ? WHERE id_calificacion = ?";
        Connection con = conexion_BD.getConnection();
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, calificacion.getId_administrativo());
            ps.setInt(2, calificacion.getId_calificacion());
            ps.setDouble(3, calificacion.getCalificacion());
            ps.setInt(4, calificacion.getId_inscripcion());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Calificacion actualizada con ID: " + calificacion.getId_calificacion());
            } else {
                System.out.println("No se encontro la calificacion con ID: " + calificacion.getId_calificacion());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM calificaciones WHERE id_calificacion = ?";
        Connection con = conexion_BD.getConnection();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Se ha eliminado la calificacion exitosamente con id " + id);
            } else {
                System.out.println("No se ha encontrado la calificacion con el id " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Calificacion> listar() {
        String sql = "SELECT * FROM calificaciones";
        Connection con = conexion_BD.getConnection();
        Calificacion cal = null;
        ArrayList<Calificacion> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                cal = new Calificacion();
                cal.setId_calificacion(rs.getInt("id_calificacion"));
                cal.setId_administrativo(rs.getInt("id_administrativo"));
                cal.setCalificacion(rs.getDouble("calificacion"));
                cal.setId_inscripcion(rs.getInt("id_inscripcion"));
                lista.add(cal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
