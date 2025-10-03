/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import java.util.List;

/**
 *
 * @author emadupre
 */
public interface manipuladorGeneral <T> {
    
    void agregar (T entidad);
    T buscarPorId (int id);
    List <T> listar();
    void actualizar(T entidad);
    int eliminar(int id);
    
}
