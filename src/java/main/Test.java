
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.bsd.OperacionTwiterImpl;
import com.dao.impl.CuentaDaoImpl;
import com.mapping.Cuenta;

/**
 *
 * @author INE
 */
public class Test {

    public static void main(String[] args) {
        //####### Esto es un modelo

        OperacionTwiterImpl daoope = new OperacionTwiterImpl();
        int cuenta = 2;
        //daoope.optenerSeguidoresPropios(cuenta);
        //daoope.optenerFriendsPropios(cuenta);
        //  daoope.purgar(cuenta);


        // Busqueda 
        double lat = 19.350000;
        double lon = -99.150002;
        double res = 5;
        String fecha = "2017-04-05";
       daoope.optenerSeguidores("desayuno", cuenta, lat, lon, res, fecha);


        //crear();
        
        // empieza a seguir 
        
        
       // daoope.Seguir();




        //"############
    }

    public static void crear() {

        CuentaDaoImpl dao = new CuentaDaoImpl();
        Cuenta c = new Cuenta();
        long ids =757675111411359744L;

        c.setId(ids);
        c.setUsuario("las_unitas");
        c.setAccessToken("757675111411359744-i5ohbHEwSOwgJtDYIB4LwG7sV8vFGo0");
        c.setAccessTokenSecret("LZT9WBRp9Tync3fp5pww4t6neb8the92Py2QAs8yUDw0D");
        c.setConsumerKey("gBY9q1YimpELH3Kr04T9nQaNS");
        c.setConsumerSecret("E8WnDMWnjn2WMGqHcg2w2POrhGllMxucgTO0D26Q9MgeYXzUiO");

        dao.insertar(c);



    }
}
