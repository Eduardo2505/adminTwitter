/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.mapping.Registrobusqueda;
import java.util.List;


public interface RegistrobusquedaDao {
    
    public Long insertar(Registrobusqueda registrobusqueda);

    public List get(Long idCuenta);
    
    public void eliminar(Long id);

    public Registrobusqueda bucar(Long idCuenta);
    
}
