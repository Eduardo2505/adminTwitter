/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as;

import org.hibernate.Session;

/**
 *
 * @author INE
 */
public interface ASOperacionTwiter {

    public void RegistroFollowers(long idTwitter, String usuario, Integer idCuenta);

    public void RegistroFriends(long idTwitter, String usuario, Integer idCuenta);

    public void RegistroFriends(long idTwitter, String usuario, Integer idCuenta, Session session);

    public Long RegistroRegistrobusqueda(String palabra, Integer idCuenta);

    public void InsertarBusqueda(long idTwitter, String usuario, long idRegistrobusqueda);
}
