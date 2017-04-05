/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Task;

import com.bsd.OperacionTwiterImpl;
import java.util.Calendar;
import java.util.TimerTask;

/**
 *
 * @author hp g4
 */
public class SimpleTimer extends TimerTask {

    @Override
    public void run() {
        doCheck();
    }

    private void doCheck() {

        System.out.println("Current time is: " + new java.util.Date());

        Calendar now = Calendar.getInstance();

        int HOUR = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if ((HOUR >= 8 && HOUR <= 23)) {

            if ((HOUR % 1) == 0) {
                OperacionTwiterImpl daoope = new OperacionTwiterImpl();
                daoope.Seguir();


            }


        }





    }
}
