/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    
    public Materia() {
        this.id_materia=-1;
    }

    public Materia(int id_materia, String nombre,String descripcion, String codigo_materia, boolean estado) {
        this.nombre = nombre;
        this.codigo_materia = codigo_materia;
        this.id_materia = id_materia;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Materia(String nombre, String descripcion, String codigo_materia, boolean estado) {
        this.id_materia=-1;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_materia = codigo_materia;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
        
        /* si el objeto m es el mismo que está como "guardado en la memoria" no hace falta comparar */
        if( this == m ) return true;
        
        /* si es null o no es de la misma clase no pueden ser iguales */
        if (m == null || getClass() != m.getClass()) return false;
        
        /* se convierte el objeto m en una materia para poder ver los atributos */
        Materia materia = (Materia) m;
        
        /* se realiza la igualdad, dos materias son iguales si tienen el mismo id_materia */
        return id_materia == materia.id_materia;
    }
    
    public int hashCode(){
        return Integer.hashCode(id_materia);
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
