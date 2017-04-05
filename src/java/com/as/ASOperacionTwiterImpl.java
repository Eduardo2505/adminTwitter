/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.as;

import com.dao.impl.FollowersDaoImpl;
import com.dao.impl.FriendsDaoImpl;
import com.dao.impl.RegistrobusquedaDaoImpl;
import com.dao.impl.SearchImpl;
import com.mapping.Cuenta;
import com.mapping.Followers;
import com.mapping.Friends;
import com.mapping.Registrobusqueda;
import com.mapping.Search;
import org.hibernate.Session;

/**
 *
 * @author INE
 */
public class ASOperacionTwiterImpl implements ASOperacionTwiter {

    @Override
    public void RegistroFollowers(long idTwitter, String usuario, Integer idCuenta) {
        FollowersDaoImpl daofollo = new FollowersDaoImpl();
        Followers fll = new Followers();
        fll.setId(idTwitter);
        fll.setEstado(0);
        fll.setUsuario(usuario);
        Cuenta c = new Cuenta();
        c.setIdcuenta(idCuenta);
        fll.setCuenta(c);
        daofollo.insertar(fll);
    }

    @Override
    public void RegistroFriends(long idTwitter, String usuario, Integer idCuenta) {
        FriendsDaoImpl daofollo = new FriendsDaoImpl();
        Friends fll = new Friends();
        fll.setId(idTwitter);
        fll.setEstado(0);
        fll.setUsuario(usuario);
        Cuenta c = new Cuenta();
        c.setIdcuenta(idCuenta);
        fll.setCuenta(c);
        daofollo.insertar(fll);
    }

    @Override
    public Long RegistroRegistrobusqueda(String palabra, Integer idCuenta) {
        RegistrobusquedaDaoImpl dar = new RegistrobusquedaDaoImpl();
        Registrobusqueda r = new Registrobusqueda();
        r.setPalabra(palabra);
        Cuenta cn = new Cuenta();
        cn.setIdcuenta(idCuenta);
        r.setCuenta(cn);
        return dar.insertar(r);
    }

    @Override
    public void InsertarBusqueda(long idTwitter, String usuario, long idRegistrobusqueda) {
        SearchImpl das = new SearchImpl();
        Search s = new Search();
        s.setId(idTwitter);
        s.setUsuario(usuario);
        s.setEstado(0);
        Registrobusqueda rr = new Registrobusqueda();
        rr.setIdRegistrobusqueda(idRegistrobusqueda);
        s.setRegistrobusqueda(rr);
        das.insertar(s);
    }

    @Override
    public void RegistroFriends(long idTwitter, String usuario, Integer idCuenta, Session session) {
        FriendsDaoImpl daofollo = new FriendsDaoImpl();
        Friends fll = new Friends();
        fll.setId(idTwitter);
        fll.setEstado(0);
        fll.setUsuario(usuario);
        Cuenta c = new Cuenta();
        c.setIdcuenta(idCuenta);
        fll.setCuenta(c);
        daofollo.insertar(fll, session);
    }
}
