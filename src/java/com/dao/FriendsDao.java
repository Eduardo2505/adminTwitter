/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.mapping.Friends;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Padilla
 */
public interface FriendsDao {

    public void insertar(Friends eriends);

    public void insertar(Friends eriends, Session session);

    public List get(int estado, long idusuario);

    public void update(Long id, int estado);

    public void eliminar(Long id);

    public Friends bucar(Integer cuenta,Long idCuenta);

    public List get(int idCuenta);
}
