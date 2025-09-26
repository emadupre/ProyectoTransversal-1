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
public class materia {
    
    private int id_materia;
    private String nombre;
    private String descripcion;
    private String codigo_materia;
    
    public materia() {}

    public materia(int id_materia, String nombre,String descripcion, String codigo_materia) {
        this.nombre = nombre;
        this.codigo_materia = codigo_materia;
        this.id_materia = id_materia;
        this.descripcion = descripcion;
    }

    public materia(String nombre, String descripcion, String codigo_materia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_materia = codigo_materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_materia() {
        return codigo_materia;
    }

    public void setCodigo_materia(String codigo_materia) {
        this.codigo_materia = codigo_materia;
    }
    
    
}
