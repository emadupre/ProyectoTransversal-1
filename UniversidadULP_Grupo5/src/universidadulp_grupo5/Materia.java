/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_grupo5;

import java.util.Objects;

/**
 *
 * @author Jose Bossa
 */
public class Materia implements Comparable<Materia>{
    
    private int id_materia;
    private String nombre;
    private String descripcion;
    private String codigo_materia;
    private boolean estado;
    
    public Materia() {}

    public Materia(int id_materia, String nombre,String descripcion, String codigo_materia, boolean estado) {
        this.nombre = nombre;
        this.codigo_materia = codigo_materia;
        this.id_materia = id_materia;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Materia(String nombre, String descripcion, String codigo_materia, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_materia = codigo_materia;
        this.estado = estado;
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
    
    @Override
    public boolean equals(Object m){
        if(m == this){
            return true;
        }
        if(m.getClass() != this.getClass() || this.id_materia ==0){
            return false;
        }
        Materia materia = (Materia) m;
        return materia.id_materia == this.id_materia;
    }
    
    public int HashCode(){
        return Objects.hashCode(this.id_materia);
    }
    
    @Override
    public int compareTo(Materia m){
        return this.nombre.compareTo(m.getNombre());
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", codigo_materia=" + codigo_materia + ", estado=" + estado + '}';
    }
    
    
    
}
