/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.mapping.Search;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author INE
 */
public interface SearchDao {

    public void insertar(Search search);

    public List get(Long idregistro);

    public void eliminar(Long id);

    public Search bucar(Long idTwiter);

    public void update(Long id, int estado,Session session);

    // public Search bucar(Long idTwiter);
    public Search resultado(Integer estado);
}
