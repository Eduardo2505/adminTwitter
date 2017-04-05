/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.mapping.Cuenta;
import java.util.List;

/**
 *
 * @author Padilla
 */
public interface CuentaDao {

    public void insertar(Cuenta cuenta);

    public List get();

    public void update(Long id, int estado);

    public void eliminar(Long id);

    public Cuenta bucar(Long idtwiter);

    public Cuenta bucar(int idcuenta);
}
