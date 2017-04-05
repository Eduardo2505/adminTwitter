/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import com.dao.SearchDao;
import com.mapping.Search;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INE
 */
public class SearchImpl implements SearchDao {

    @Override
    public void insertar(Search search) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(search);
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
    public List get(Long idregistro) {
        List<Search> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            Query q = session.createQuery("From Search");
            list = (List< Search>) q.list();

        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public void eliminar(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Search tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Search) session.get(Search.class, id);

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
    public Search bucar(Long idregistro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Search empleado = null;
        int total = 0;
        try {

            String sql = "select u from Cuenta u where  id=:id";
            Query query = session.createQuery(sql);
            query.setLong("id", idregistro);
            empleado = (Search) query.uniqueResult();

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
        return empleado;
    }

    @Override
    public Search resultado(Integer estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Search empleado = null;
        int total = 0;
        try {

            String sql = "select u from Search u where  estado="+estado+" order by registro";
            Query query = session.createQuery(sql);
            query.setMaxResults(1);

            empleado = (Search) query.uniqueResult();

        } catch (Exception e) {

            return null;

        } finally {
            //session.close();
        }
        return empleado;
    }

    @Override
    public void update(Long id, int estado, Session session) {

        Search tbl01Categoria = null;
        tbl01Categoria = (Search) session.get(Search.class, id);
        tbl01Categoria.setEstado(estado);
        session.update(tbl01Categoria);

    }
}
