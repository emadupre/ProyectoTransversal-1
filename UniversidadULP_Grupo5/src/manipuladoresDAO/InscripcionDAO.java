/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

import java.util.ArrayList;
import java.util.List;
import universidadulp_grupo5.Inscripcion;

/**
 *
 * @author Enzo_2
 */
public class InscripcionDAO implements manipuladorGeneral <Inscripcion> {

    @Override
    public void agregar(Inscripcion inscripcion) {
        
    }

    @Override
    public Inscripcion buscarPorId(int id) {
        return new Inscripcion();
    }

    @Override
    public List<Inscripcion> listar() {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Inscripcion inscripcion) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }
    
}
