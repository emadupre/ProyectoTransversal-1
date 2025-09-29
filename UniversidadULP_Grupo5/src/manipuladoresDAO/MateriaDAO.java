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
import universidadulp_grupo5.Materia;

/**
 *
 * @author Enzo_2
 */
public class MateriaDAO implements manipuladorGeneral <Materia> {

    @Override
    public void agregar(Materia materia) {
     
    }

    @Override
    public Materia buscarPorId(int id) {
        return new Materia();
    }

    @Override
    public List<Materia> listar(int id) {
        String sql = "SELECT * FROM inscripcion where id_materia = ?";
        Connection con = conexion_BD.getConnection();
        Materia materia = null;
        ArrayList<Materia> materias = new ArrayList<>();
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
           ps.setInt(1, id);
           try(ResultSet rs = ps.executeQuery()){
               while(rs.next()){
                   materia = new Materia();
                   materia.setId_materia(rs.getInt("id_materia"));
                   materia.setNombre(rs.getNString(" nombre"));
                   materia.setDescripcion(rs.getNString("descripcion"));
                   materia.setCodigo_materia(rs.getNString("codigo_materia "));
                   materia.setEstado(rs.getBoolean("estado"));
                   materias.add(materia);
               }
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        
        return materias;
    }

    @Override
    public void actualizar(Materia materia) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }

    
    
}
