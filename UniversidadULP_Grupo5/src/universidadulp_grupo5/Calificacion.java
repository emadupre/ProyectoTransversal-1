
package universidadulp_grupo5;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Jose Bossa
 */
public class Calificacion {
    private int id_calificacion;
    private int id_inscripcion;
    private int id_administrativo;
    private double calificacion;
    private LocalDate fechaModificacion;
        public Calificacion() {
            this.id_calificacion=-1;
        }

    public Calificacion(int id_inscripcion,int id_administrativo, double calificacion) {
        this.id_calificacion=-1;
        this.id_inscripcion = id_inscripcion;
        this.calificacion = calificacion;
        this.id_administrativo = id_administrativo;
    }

    public Calificacion(int id_calificacion, int id_inscripcion, int id_administrativo, double calificacion) {
        this.id_calificacion = id_calificacion;
        this.id_inscripcion = id_inscripcion;
        this.calificacion = calificacion;
        this.id_administrativo = id_administrativo;
    }

    public Calificacion(int id_inscripcion, int id_administrativo, double calificacion, LocalDate fechaModificacion) {
        this.id_inscripcion = id_inscripcion;
        this.id_administrativo = id_administrativo;
        this.calificacion = calificacion;
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    

    public int getId_administrativo() {
        return id_administrativo;
    }

    public void setId_administrativo(int id_administrativo) {
        this.id_administrativo = id_administrativo;
    }
    

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

     @Override
    public boolean equals(Object c){
        if(c == this){
            return true;
        }
        if(c.getClass() != this.getClass() || this.id_calificacion == 0){
            return false;
        }
        Calificacion cal = (Calificacion) c;
        return this.id_calificacion == cal.id_calificacion;
    }
    
    public int HashCode(){
        return Objects.hashCode(this.id_calificacion);
    }

    @Override
    public String toString() {
        return "Calificacion{" + "id_calificacion=" + id_calificacion + ", id_inscripcion=" + id_inscripcion + ", id_administrativo=" + id_administrativo + ", calificacion=" + calificacion + '}';
    }
    
    
    
}
