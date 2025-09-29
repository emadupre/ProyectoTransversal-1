/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

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
        //
    }

    @Override
    public Materia buscarPorId(int id) {
        return new Materia();
    }

    @Override
    public List<Materia> listar(int id) {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Materia materia) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }

    
    
}
