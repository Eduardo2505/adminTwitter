/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author INE
 */
public class config {

    public Twitter conexion(String key, String Secre, String token, String tiketSecret) {
        Twitter tw = null;
        ConfigurationBuilder cb = new ConfigurationBuilder();
/// este configuracion de carrito
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(key)
                .setOAuthConsumerSecret(Secre)
                .setOAuthAccessToken(token)
                .setOAuthAccessTokenSecret(tiketSecret);
        // configuracion de kozma

        TwitterFactory tf = new TwitterFactory(cb.build());

        return tw = tf.getInstance();
    }

    public config() {
    }

    
}
