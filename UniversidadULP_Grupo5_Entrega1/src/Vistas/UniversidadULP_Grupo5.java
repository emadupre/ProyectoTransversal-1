package Vistas;


import java.time.LocalDate;
import java.util.List;
import Persistencia.AlumnoDAO;
import Modelo.Alumno;



/**
 *
 * @author Enzo_2
 */
public class UniversidadULP_Grupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnoDAO manipuladorAlum = new AlumnoDAO();
        
        
        System.out.println("Creando alumnos.... \n");
        /* Creacion de alumnos */
        Alumno claudia = new Alumno(23498345, "clau_bonisoni@gmail.com", "tengo20", "Claudia", "Bonisoni", LocalDate.of(2000, 8, 10), true);
        Alumno gonza = new Alumno (45750462,"achucarrogonza8@gmail.com","holaquehace44","Gonzalo","Achucarro",LocalDate.of(2004,9,4),true);
        Alumno naiara = new Alumno (43426456,"naiaraayelen129@gmail.com","lupitapita","Naiara","Bongiovanni",LocalDate.of(2001,6,7),true);
        Alumno jose = new Alumno (41721827,"jose.bossa.3@gmail.com","lagalletaquepella123","José","Bossa",LocalDate.of(1999,1,19),true);
        Alumno enzo = new Alumno (40298592,"enzofet1998@gmail.com","alohaloquitas","Enzo","Fet",LocalDate.of(1998,10,23),true);
        Alumno ema = new Alumno (40298592,"ema.dupre@gmail.com","mantecosa123","Jesús Emanuel","García",LocalDate.of(1998,6,28),true);
        System.out.println("Alumnos creados. \n");
        
        
        System.out.println("Alumnos cargados a la base de datos..\n");
        /* Agregación de alumnos a la base de datos */
        manipuladorAlum.agregar(claudia);
        manipuladorAlum.agregar(gonza);
        manipuladorAlum.agregar(naiara);
        manipuladorAlum.agregar(jose);
        manipuladorAlum.agregar(enzo);
        manipuladorAlum.agregar(ema);
        
        
        System.out.println("Listando Alumnos: \n");
        /* Listar Alumnos */
        List<Alumno> listar = manipuladorAlum.listar();
            for(Alumno a : listar){
                System.out.println(a);
            }
        
            
        System.out.println("Busqueda de Alumno por ID \n");
        /* Busqueda de Alumno según ID */
        Alumno buscarID = manipuladorAlum.buscarPorId(6);
        System.out.println(buscarID);
        /* Buscamos al Alumno Jesús Emanuel */
        
        System.out.println("Eliminando alumno...\n");
        /* Baja de Alumno según ID */
        int bajaID = manipuladorAlum.eliminar(6);
        System.out.println(bajaID);
        /* Se elimina el Alumno Jesús Emanuel */
        System.out.println("Alumno eliminado correctamente.\n");
        
    }
}
