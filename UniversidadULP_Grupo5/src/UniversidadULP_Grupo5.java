
import java.util.List;
import manipuladoresDAO.InscripcionDAO;
import universidadulp_grupo5.Inscripcion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Enzo_2
 */
public class UniversidadULP_Grupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InscripcionDAO manipulador = new InscripcionDAO();
        

        Inscripcion ins1 = new Inscripcion(1, 2, false);
        manipulador.eliminar(1);
       
        
       
     
        
        
    }
}
