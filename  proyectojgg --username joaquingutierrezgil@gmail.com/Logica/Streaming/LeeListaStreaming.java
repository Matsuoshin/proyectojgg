/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Streaming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import Persistencia.ListasReproduccion;
import Interfaz.Principal;
import java.io.IOException;

/**
 *
 * @author Joaquín
 */
public class LeeListaStreaming {

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private ListasReproduccion listas = new ListasReproduccion();
    private Principal p = null;

    public void leeFichero() {
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("C:\\ConfigStreaming\\listaStreaming.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            p = new Principal();
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                //listas.addStreaming(linea);
                System.out.println("Rellenar streaming");
            }

            //listas.recorreLista();

        } catch (Exception e) {
            System.out.println("Error en la lectura del fichero: " + e.getMessage());
        }finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }
}
