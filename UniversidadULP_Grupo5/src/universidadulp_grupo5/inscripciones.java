/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_grupo5;


/**
 *
 * @author Jose Bossa
 */
public class inscripciones {
    private int id_inscripcion;
    private int id_usuario;
    private int id_materia;
    private boolean estado;
    
    public inscripciones() {}

    public inscripciones(int id_usuario, int id_materia, boolean estado) {
        this.id_usuario = id_usuario;
        this.id_materia = id_materia;
        this.estado = estado;
    }

    public inscripciones(int id_inscripcion, int id_usuario, int id_materia, boolean estado) {
        this.id_inscripcion = id_inscripcion;
        this.id_usuario = id_usuario;
        this.id_materia = id_materia;
        this.estado = estado;
    }


    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    
}
