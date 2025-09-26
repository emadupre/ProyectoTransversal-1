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
    private int id_usuario;
    private String nombre;
    private String codigo_materia;

    public materia(int id_usuario, String nombre, String codigo_materia) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.codigo_materia = codigo_materia;
    }

    public materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public materia() {
    }

    

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
