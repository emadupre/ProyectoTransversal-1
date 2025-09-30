/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

import java.util.ArrayList;
import java.util.List;
import universidadulp_grupo5.Calificacion;

/**
 *
 * @author Enzo_2
 */
public class CalificacionDAO implements manipuladorGeneral <Calificacion> {

    @Override
    public void agregar(Calificacion calificacion) {
       
    }

    @Override
    public Calificacion buscarPorId(int id) {
        return new Calificacion();
    }

    @Override
    public List<Calificacion> listar() {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Calificacion calificacion) {
        
    }

    @Override
    public void eliminar(int id) {

    }

}
