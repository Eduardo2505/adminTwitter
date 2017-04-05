/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsd;

import com.as.ASOperacionTwiterImpl;
import com.config.config;
import com.dao.impl.CuentaDaoImpl;
import com.dao.impl.FollowersDaoImpl;
import com.dao.impl.FriendsDaoImpl;
import com.dao.impl.SearchImpl;
import com.dto.FriendsDTO;
import com.mapping.Cuenta;
import com.mapping.Followers;
import com.mapping.Friends;
import com.mapping.Registrobusqueda;
import com.mapping.Search;
import com.util.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import twitter4j.GeoLocation;
import twitter4j.IDs;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author INE
 */
public class OperacionTwiterImpl implements OperacionTwiter {

    @Override
    public void purgar(int IdCuenta) {

        // conexion a twiter
        config con = new config();
        Twitter tw = null;
        CuentaDaoImpl dac = new CuentaDaoImpl();
        Cuenta c = new Cuenta();
        c = dac.bucar(IdCuenta);
        try {
            tw = con.conexion(c.getAccessToken(), c.getAccessTokenSecret(), c.getConsumerKey(), c.getConsumerSecret());



            FriendsDaoImpl dao = new FriendsDaoImpl();
            List lis = dao.get(IdCuenta);
            Iterator itex = lis.iterator();

            //este es la interaccion
            FollowersDaoImpl dum = new FollowersDaoImpl();
            while (itex.hasNext()) {
                FriendsDTO p = (FriendsDTO) itex.next();
                Followers b = new Followers();
                b = dum.bucar(IdCuenta, p.getId());
                if (b == null) {
                    System.out.println("Deje de seguir >>>>>>>>>>>>> " + p.getId());

                    dao.eliminar(p.getIdFriends());
                    tw.destroyFriendship(p.getId());// este es para dejar de seguir





                }



            }

        } catch (TwitterException ex) {
            Logger.getLogger(OperacionTwiterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    @Override
    public void optenerSeguidores(String Buscaqueda, int IdCuenta, double lat, double lon, double res, String fecha) {
        config con = new config();
        Twitter tw = null;
        CuentaDaoImpl dac = new CuentaDaoImpl();
        Cuenta c = new Cuenta();
        c = dac.bucar(IdCuenta);

        tw = con.conexion(c.getAccessToken(), c.getAccessTokenSecret(), c.getConsumerKey(), c.getConsumerSecret());

        ASOperacionTwiterImpl dao = new ASOperacionTwiterImpl();
        long idRegistrobusqueda = dao.RegistroRegistrobusqueda(Buscaqueda, c.getIdcuenta());
        try {
            Query query = new Query(Buscaqueda);
            QueryResult result;
            // double lat = 19.350000;
//            double lon = -99.150002;
//            double res = 5;
            String resUnit = "mi";
            SearchImpl daob = new SearchImpl();
            do {
                query.geoCode(new GeoLocation(lat, lon), res, resUnit);
                query.setSince(fecha);
                query.setCount(100);
                result = tw.search(query);


                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    Search n = new Search();
                    n = daob.bucar(tweet.getUser().getId());
                    if (n == null) {
                        dao.InsertarBusqueda(tweet.getUser().getId(), tweet.getUser().getScreenName(), idRegistrobusqueda);
                        System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText() + ">>>>" + tweet.getCreatedAt());
                    }






                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }






    }

    @Override
    public void optenerSeguidoresPropios(int idcuenta) {
        config con = new config();
        Twitter tw = null;
        CuentaDaoImpl dac = new CuentaDaoImpl();
        Cuenta c = new Cuenta();
        c = dac.bucar(idcuenta);
        try {
            tw = con.conexion(c.getAccessToken(), c.getAccessTokenSecret(), c.getConsumerKey(), c.getConsumerSecret());

            long cursor = -1;
            IDs ids;

            int a = 1;
            ASOperacionTwiterImpl dao = new ASOperacionTwiterImpl();
            FollowersDaoImpl df = new FollowersDaoImpl();

            do {
                ids = tw.getFollowersIDs(c.getId(), cursor, 5000); // lista de seguidores
                for (long id : ids.getIDs()) {

                    Followers f = new Followers();
                    f = df.bucar(idcuenta, id);
                    if (f == null) {
                        System.out.println("id>>>> " + id + " idcuenta" + idcuenta);
                        long d = id;
                        dao.RegistroFollowers(d, "-", idcuenta);




                    }


                }

            } while ((cursor = ids.getNextCursor()) != 0);
            System.exit(0);

        } catch (TwitterException ex) {
            Logger.getLogger(OperacionTwiterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void optenerFriendsPropios(int idcuenta) {
        config con = new config();
        Twitter tw = null;
        CuentaDaoImpl dac = new CuentaDaoImpl();
        Cuenta c = new Cuenta();
        c = dac.bucar(idcuenta);
        try {
            tw = con.conexion(c.getAccessToken(), c.getAccessTokenSecret(), c.getConsumerKey(), c.getConsumerSecret());

            long cursor = -1;
            IDs ids;

            int a = 1;
            ASOperacionTwiterImpl dao = new ASOperacionTwiterImpl();
            FriendsDaoImpl df = new FriendsDaoImpl();

            do {
                ids = tw.getFriendsIDs(c.getId(), cursor, 5000); // lista de seguidores
                for (long id : ids.getIDs()) {

                    Friends f = new Friends();
                    f = df.bucar(idcuenta, id);
                    if (f == null) {
                        System.out.println("id>>>> " + id + " IdCuenta" + idcuenta);
                        long d = id;
                        dao.RegistroFriends(d, "-", idcuenta);




                    }


                }

            } while ((cursor = ids.getNextCursor()) != 0);
            System.exit(0);

        } catch (TwitterException ex) {
            Logger.getLogger(OperacionTwiterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Seguir() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Search tbl01Categoria = null;
        try {
            tx = session.beginTransaction();


            SearchImpl dai = new SearchImpl();
            Search d = new Search();
            Integer esa = 0;
            d = dai.resultado(esa);
            Registrobusqueda r = new Registrobusqueda();
            r = d.getRegistrobusqueda();
            Cuenta c = new Cuenta();
            c = r.getCuenta();
            int esta = 1;
            ASOperacionTwiterImpl dao = new ASOperacionTwiterImpl();
            dai.update(d.getIdsearch(), esta, session);
            FriendsDaoImpl daob = new FriendsDaoImpl();
            Friends df = new Friends();
            df = daob.bucar(c.getIdcuenta(), d.getId());
            if (df == null) {
                dao.RegistroFriends(d.getId(), d.getUsuario(), c.getIdcuenta(), session);

            }

            config con = new config();
            Twitter tw = null;
            CuentaDaoImpl dac = new CuentaDaoImpl();

            c = dac.bucar(c.getIdcuenta());

            tw = con.conexion(c.getAccessToken(), c.getAccessTokenSecret(), c.getConsumerKey(), c.getConsumerSecret());

            tw.createFriendship(d.getId());

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
    public void destroyFriendship() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();


            SearchImpl dai = new SearchImpl();
            Search d = new Search();
            Integer esa = 1;
            d = dai.resultado(esa);
            Registrobusqueda r = new Registrobusqueda();
            r = d.getRegistrobusqueda();
            Cuenta c = new Cuenta();
            c = r.getCuenta();

            FollowersDaoImpl da = new FollowersDaoImpl();
            Followers f = new Followers();
            f = da.bucar(c.getIdcuenta(), d.getId());

            if (f == null) {
                //eliminar 

                FriendsDaoImpl daof = new FriendsDaoImpl();
                Friends fr = new Friends();
                fr = daof.bucar(c.getIdcuenta(), d.getId());

                config con = new config();
                Twitter tw = null;
                CuentaDaoImpl dac = new CuentaDaoImpl();
                c = dac.bucar(c.getIdcuenta());
                tw = con.conexion(c.getAccessToken(), c.getAccessTokenSecret(), c.getConsumerKey(), c.getConsumerSecret());

                tw.destroyFriendship(d.getId());

                dai.eliminar(d.getIdsearch());
                if (fr != null) {
                    daof.eliminar(fr.getIdFriends());
                }



            }







            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            session.close();

        }
    }
}
