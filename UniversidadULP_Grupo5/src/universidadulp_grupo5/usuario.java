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
public class usuario {
    private int id_usuario;
    private int dni;
    private String usuario;
    private String email;
    private String password;
    private String nombre;
    private String Apellido;
    private Date fechaNacimiento;

    public usuario(int dni, String usuario, String email, String password, String nombre, String Apellido, Date fechaNacimiento) {
        this.dni = dni;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public usuario() {
    }
    
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
            

    
    
    
    
    
}
