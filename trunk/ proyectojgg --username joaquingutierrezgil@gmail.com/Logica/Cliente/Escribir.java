/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author joaquin
 */
public class Escribir implements IEscribir {

    /*
     * Clase para escribir la dirección IP pública a la que el cliente
     * debe conectarse.
     */
    //String que indica el nombre del fichero de configuracion
    private String sFichero = "config.txt";

    public Escribir() {
        //No hago nada :)
    }

    @Override
    public void escribirIP(String ip) {
        try {
            //Creamos una variable de tipo FILE para el fichero
            File fichero = new File(sFichero);

            //Escribimos la IP
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write(ip);

            //Cerramos el fichero
            bw.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void escribir(String ip) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\ConfigStreaming\\config.txt");
            pw = new PrintWriter(fichero);

            pw.println(ip);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

    }
}
