/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.mapping.Followers;
import java.util.List;

/**
 *
 * @author PAdilla
 */
public interface FollowersDao {

    public void insertar(Followers followers);

    public List get(int estado, int usuario);

    public void update(Long id, int estado);

    public void eliminar(Long id);

    public Followers bucar(Integer idCuenta,Long idTwiter);
}
