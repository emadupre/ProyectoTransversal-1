/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipuladoresDAO;

import java.util.ArrayList;
import java.util.List;
import universidadulp_grupo5.Administrativo;

/**
 *
 * @author Enzo_2
 */
public class AdministrativoDAO implements manipuladorGeneral <Administrativo> {

    @Override
    public void agregar(Administrativo administrativo) {
        
    }

    @Override
    public Administrativo buscarPorId(int id) {
        return new Administrativo();
    }

    @Override
    public List<Administrativo> listar(int id) {
        return new ArrayList<>();
    }

    @Override
    public void actualizar(Administrativo administrativo) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }

}
