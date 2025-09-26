/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_grupo5;

import java.util.Date;

/**
 *
 * @author Jose Bossa
 */
public class inscripciones {
    private int id_inscripcion;
    private int id_usuario;
    private int id_materia;
    private String estado;
    private Date FechaInscripcion;

    public inscripciones(int id_usuario, int id_materia, String estado, Date FechaInscripcion) {
        this.id_usuario = id_usuario;
        this.id_materia = id_materia;
        this.estado = estado;
        this.FechaInscripcion = FechaInscripcion;
    }

    public inscripciones(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public inscripciones() {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInscripcion() {
        return FechaInscripcion;
    }

    public void setFechaInscripcion(Date FechaInscripcion) {
        this.FechaInscripcion = FechaInscripcion;
    }

    
    
}
