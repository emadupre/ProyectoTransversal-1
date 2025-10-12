/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp_grupo5;
import java.time.LocalDate;
import java.util.Objects;
/**
 *
 * @author Jose Bossa
 */
public class Alumno implements Comparable<Alumno>{
    private int id_alumno;
    private int dni;
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private boolean estado;
    
    public Alumno() {
        this.id_alumno=-1;
    }

    public Alumno(int id_alumno, int dni, String email, String password, String nombre, String apellido, LocalDate fecha_nacimiento, boolean estado) {
        this.id_alumno = id_alumno;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public Alumno(int dni, String email, String password, String nombre, String apellido, LocalDate fecha_nacimiento, boolean estado) {
        this.id_alumno=-1;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
            
    @Override
    public boolean equals(Object a){
        if(a == this){
            return true;
        }
        if(a.getClass() != this.getClass() || this.dni == 0){
            return false;
        }
        Alumno alum = (Alumno) a;
        return alum.dni == this.dni;
    }
    
    public int HashCode(){
        return Objects.hashCode(this.id_alumno);
    }
    
    @Override
    public int compareTo(Alumno a){
        return this.apellido.compareTo(a.apellido);    }

    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", dni=" + dni + ", email=" + email + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fecha_nacimiento + ", estado=" + estado + '}';
    } 
}
