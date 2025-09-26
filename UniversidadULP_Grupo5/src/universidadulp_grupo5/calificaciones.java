
package universidadulp_grupo5;

/**
 *
 * @author Jose Bossa
 */
public class calificaciones {
    private int id_calificaciones;
    private int id_inscripcion;
    private double calificacion;

    public calificaciones(int id_inscripcion, double calificacion) {
        this.id_inscripcion = id_inscripcion;
        this.calificacion = calificacion;
    }

    public calificaciones(int id_calificaciones) {
        this.id_calificaciones = id_calificaciones;
    }

    public calificaciones() {
    }

    public int getId_calificaciones() {
        return id_calificaciones;
    }

    public void setId_calificaciones(int id_calificaciones) {
        this.id_calificaciones = id_calificaciones;
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

    
    
}
