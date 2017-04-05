/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import com.dao.CuentaDao;
import com.mapping.Cuenta;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author INE
 */
public class CuentaDaoImpl implements CuentaDao {

    @Override
    public void insertar(Cuenta cuenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cuenta);
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
    public List get() {
        List<Cuenta> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            Query q = session.createQuery("From Cuenta");
            list = (List< Cuenta>) q.list();

        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public void update(Long id, int estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Cuenta tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Cuenta) session.get(Cuenta.class, id);
            // tbl01Categoria.setEstado(estado);
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
        Cuenta tbl01Categoria = null;
        try {
            tx = session.beginTransaction();
            tbl01Categoria = (Cuenta) session.get(Cuenta.class, id);

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
    public Cuenta bucar(Long idwiter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cuenta empleado = null;
        int total = 0;
        try {

            String sql = "select u from Cuenta u where  id=:id";
            Query query = session.createQuery(sql);
            query.setLong("id", idwiter);
            empleado = (Cuenta) query.uniqueResult();

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
        return empleado;
    }

    @Override
    public Cuenta bucar(int idcuenta) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        Cuenta tbl01Categoria = null;
        try {

            tbl01Categoria = (Cuenta) session.get(Cuenta.class, idcuenta);

        } catch (Exception e) {

            return null;

        } finally {
            session.close();
        }
        return tbl01Categoria ;
    }
}
