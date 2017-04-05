/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsd;

/**
 *
 * @author INE
 */
public interface OperacionTwiter {

    public void purgar(int IdCuenta);

    public void optenerSeguidores(String Buscaqueda, int idcuenta,double lat,double lon,double res,String fecha);

    public void optenerSeguidoresPropios(int idcuenta);

    public void optenerFriendsPropios(int idcuenta);
    
    
    public void Seguir();
    
    public void destroyFriendship();
}
