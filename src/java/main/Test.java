
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
        //int cuenta = 1;
        //daoope.optenerSeguidoresPropios(cuenta);
        //daoope.optenerFriendsPropios(cuenta);
        //  daoope.purgar(cuenta);


        // Busqueda 
        double lat = 19.350000;
        double lon = -99.150002;
        double res = 5;
        String fecha = "2016-01-01";
      //  daoope.optenerSeguidores("desayuno", cuenta, lat, lon, res, fecha);


        //crear();
        
        // empieza a seguir 
        
        
        daoope.Seguir();




        //"############
    }

    public static void crear() {

        CuentaDaoImpl dao = new CuentaDaoImpl();
        Cuenta c = new Cuenta();
        long ids = 3033706820L;

        c.setId(ids);
        c.setUsuario("carritoenlinea");
        c.setAccessToken("vIinKJeYxPnFa9I9j8WzV7VLt");
        c.setAccessTokenSecret("rrEbe8Awm9mBgdoGWQawn3p9nAKOW5xJ6NS2jWeiZ03mOaDRj8");
        c.setConsumerKey("3033706820-VD64ZRYqoLmHUqmx3ETUZEc4uHW8aQ4iWdeLfen");
        c.setConsumerSecret("ubssQLndnQyT3mYaX3EaxXaJKoLckqTfX4mf2MNCTLriL");

        dao.insertar(c);



    }
}
