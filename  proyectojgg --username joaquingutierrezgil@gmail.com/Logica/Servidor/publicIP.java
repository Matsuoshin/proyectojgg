/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author joaquin
 */
public class publicIP implements IPublicIP {

    public String publicIP;

    public publicIP() {
        //No hago nada :)
    }

    @Override
    public String getIP() {
        try {
            URL tempURL = new URL("http://www.informatizando.es/ip.php/");
            HttpURLConnection tempConn = (HttpURLConnection) tempURL.openConnection();
            InputStream tempInStream = tempConn.getInputStream();
            InputStreamReader tempIsr = new InputStreamReader(tempInStream);
            BufferedReader tempBr = new BufferedReader(tempIsr);

            publicIP = tempBr.readLine();

            tempBr.close();
            tempInStream.close();

        } catch (Exception ex) {
            publicIP = "<No es posible resolver la direccion IP>";
        }

        return publicIP;
    }
}
