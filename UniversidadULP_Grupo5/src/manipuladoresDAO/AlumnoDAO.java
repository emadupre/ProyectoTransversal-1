/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

import java.util.ArrayList;
import java.util.List;
import universidadulp_grupo5.Alumno;

/**
 *
 * @author Enzo_2
 */
public class AlumnoDAO implements manipuladorGeneral <Alumno> {

    @Override
    public void agregar(Alumno alumno) {
        
    }

    @Override
    public Alumno buscarPorId(int id) {
        return new Alumno();
    }

    @Override
    public List<Alumno> listar(int id) {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Alumno alumno) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }

}