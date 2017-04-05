/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import com.dao.RegistrobusquedaDao;
import com.mapping.Registrobusqueda;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INE
 */
public class RegistrobusquedaDaoImpl implements RegistrobusquedaDao {

    @Override
    public Long insertar(Registrobusqueda registrobusqueda) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(registrobusqueda);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

        } finally {

            session.close();

        }
        return registrobusqueda.getIdRegistrobusqueda();
    }

    @Override
    public List get(Long idCuenta) {
        List<Registrobusqueda> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            Query q = session.createQuery("From Registrobusqueda");
            list = (List< Registrobusqueda>) q.list();

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
        Registrobusqueda tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Registrobusqueda) session.get(Registrobusqueda.class, id);

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
    public Registrobusqueda bucar(Long idCuenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Registrobusqueda empleado = null;
        int total = 0;
        try {

            String sql = "select u from Cuenta u where  id=:id";
            Query query = session.createQuery(sql);
            query.setLong("id", idCuenta);
            empleado = (Registrobusqueda) query.uniqueResult();

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
        return empleado;
    }
}
