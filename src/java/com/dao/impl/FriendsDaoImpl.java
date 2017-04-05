/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import com.dao.FriendsDao;
import com.dto.FriendsDTO;
import com.mapping.Friends;
import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author INE
 */
public class FriendsDaoImpl implements FriendsDao {

    @Override
    public void insertar(Friends eriends) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(eriends);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

        } finally {

            session.close();

        }
    }

    @Override
    public List get(int estado, long idusuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<FriendsDTO> dto = new ArrayList<FriendsDTO>();
        SQLQuery query = null;


        String cadenaQuery = "select  "
                + "    idFriends, id, estado, idcuenta, registro "
                + "from "
                + "    followers "
                + "where "
                + "    estado like " + estado + " and idcuenta = " + idusuario + "";
        query = session.createSQLQuery(cadenaQuery)
                .addScalar("idFriends", Hibernate.LONG)
                .addScalar("id", Hibernate.STRING)
                .addScalar("estado", Hibernate.INTEGER)
                .addScalar("idcuenta", Hibernate.INTEGER)
                .addScalar("registro", Hibernate.DATE);
        query.setResultTransformer(Transformers.aliasToBean(FriendsDTO.class));
        dto = (ArrayList<FriendsDTO>) query.list();

        return dto;
    }

    @Override
    public void update(Long id, int estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Friends tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Friends) session.get(Friends.class, id);
            tbl01Categoria.setEstado(estado);
            session.update(tbl01Categoria);
            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            session.close();

        }
    }

    @Override
    public void eliminar(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Friends tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Friends) session.get(Friends.class, id);

            session.delete(tbl01Categoria);
            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            session.close();

        }
    }

    @Override
    public Friends bucar(Integer cuenta,Long idCuenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Friends empleado = null;
        int total = 0;
        try {

            String sql = "select u from Friends u where  id=:id and idcuenta:idc";
            Query query = session.createQuery(sql);
            query.setLong("id", idCuenta);
            query.setInteger("idc", cuenta);
            empleado = (Friends) query.uniqueResult();

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
        return empleado;
    }

    @Override
    public List get(int idCuenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<FriendsDTO> dto = new ArrayList<FriendsDTO>();
        SQLQuery query = null;


        String cadenaQuery = "select  "
                + "    idFriends, id, estado, idcuenta, registro "
                + "from "
                + "    friends "
                + "where "
                + "     idcuenta = " + idCuenta + "";
        System.out.println(cadenaQuery);
        query = session.createSQLQuery(cadenaQuery)
                .addScalar("idFriends", Hibernate.LONG)
                .addScalar("id",Hibernate.LONG)
                .addScalar("estado", Hibernate.INTEGER)
                .addScalar("idcuenta", Hibernate.INTEGER)
                .addScalar("registro", Hibernate.DATE);
        query.setResultTransformer(Transformers.aliasToBean(FriendsDTO.class));
        dto = (ArrayList<FriendsDTO>) query.list();

        return dto;
    }

    @Override
    public void insertar(Friends eriends, Session session) {
       
            session.save(eriends);
       
    }
}
