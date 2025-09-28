/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_grupo5;


import java.util.Objects;

/**
 *
 * @author Enzo_2
 */
public class Administrativo implements Comparable<Administrativo>{

    private int id_administrativo;
    private int dni;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private long telefono;

    public Administrativo() {
    }

    public Administrativo(int id_administrativo, int dni, String nombre, String apellido, String email, String password, long telefono) {
        this.id_administrativo = id_administrativo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public Administrativo(int dni, String nombre, String apellido, String email, String password, long telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public int getId_administrativo() {
        return id_administrativo;
    }

    public void setId_administrativo(int id_administrativo) {
        this.id_administrativo = id_administrativo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public boolean equals(Object a){
        if(this == a){
            return true;
        }
        if(this.getClass() != a.getClass() || this.id_administrativo == 0){
            return false;
        }
        Administrativo admin = (Administrativo)a;
        return admin.id_administrativo == this.id_administrativo;
    }
    
    public int HashCode(){
        return Objects.hash(id_administrativo);
    }
    
    @Override
    public int compareTo(Administrativo a){
        return this.apellido.compareTo(a.apellido);
    }

}
