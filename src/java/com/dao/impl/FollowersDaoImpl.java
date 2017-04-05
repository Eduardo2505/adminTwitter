/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import com.dao.FollowersDao;
import com.dto.FollowersDTO;
import com.mapping.Followers;
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
public class FollowersDaoImpl implements FollowersDao {

    @Override
    public void insertar(Followers followers) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(followers);
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
    public List get(int estado, int usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<FollowersDTO> dto = new ArrayList<FollowersDTO>();
        SQLQuery query = null;


        String cadenaQuery = "select  "
                + "    idFollowers, id, estado, idcuenta, registro "
                + "from "
                + "    followers "
                + "where "
                + "    estado = " + estado + " and idcuenta = " + usuario + "";
        query = session.createSQLQuery(cadenaQuery)
                .addScalar("idFollowers", Hibernate.LONG)
                .addScalar("id", Hibernate.STRING)
                .addScalar("estado", Hibernate.INTEGER)
                .addScalar("idcuenta", Hibernate.INTEGER)
                .addScalar("registro", Hibernate.DATE);
        query.setResultTransformer(Transformers.aliasToBean(FollowersDTO.class));
        dto = (ArrayList<FollowersDTO>) query.list();

        return dto;
    }

    @Override
    public void update(Long id, int estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Followers tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Followers) session.get(Followers.class, id);
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
        Followers tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Followers) session.get(Followers.class, id);

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
    public Followers bucar(Integer idCuenta,Long idTwiter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Followers empleado = null;
        int total = 0;
        try {

            String sql = "select u from Followers u where  idcuenta:id and id:iduser";
            Query query = session.createQuery(sql);
            query.setInteger("id", idCuenta);
            query.setLong("iduser", idTwiter);
            empleado = (Followers) query.uniqueResult();

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
        return empleado;
    }
}
