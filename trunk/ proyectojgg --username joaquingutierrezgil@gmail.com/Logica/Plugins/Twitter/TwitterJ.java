/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Plugins.Twitter;

import twitter4j.*;

/**
 *
 * @author Joaquín
 */
public class TwitterJ {

         private Twitter mi_twitter;

    public TwitterJ(String userName, String password) {
        try {
            mi_twitter = new Twitter(userName, password);
            mi_twitter.verifyCredentials();
        } catch (TwitterException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    public void nuevoTweet(String tweet) {
        try {
            this.mi_twitter.updateStatus(tweet);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void main(String args[]){
        TwitterJ mi_twitter = new TwitterJ("user", "pass");
        mi_twitter.nuevoTweet("Tweet");
    }
}
