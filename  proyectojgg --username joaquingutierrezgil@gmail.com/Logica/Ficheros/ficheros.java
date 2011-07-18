/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Joaquín
 */
public class ficheros {

    //Editar y crear
    FileWriter fichero = null;
    PrintWriter pw = null;
    //Leer
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    public void editarFichero(String directorio, String archivo) {
        try {
            fichero = new FileWriter(archivo, true);
            pw = new PrintWriter(fichero);


            pw.println(directorio);

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

    public void crearFichero(String texto, String nombre) {

        try {
            fichero = new FileWriter("C:\\ConfigStreaming\\" + nombre + ".txt");
            pw = new PrintWriter(fichero);

            pw.println(texto);

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

     public void cFichero(String ruta, String texto, String nombre) {

        try {
            fichero = new FileWriter(ruta + "\\" + nombre + ".txt");
            System.out.println(fichero.toString());
            pw = new PrintWriter(fichero);

            pw.println(texto);

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

    public String leeFichero(String st) {
        // Lectura del fichero
        String linea = "nulo";

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(st);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            if (linea != null) {
                linea = br.readLine();
            }

            /*
            while ((linea = br.readLine()) != null) {
            System.out.println(linea);
            }
             * 
             */
        } catch (Exception e) {
            e.getMessage();
        } finally {
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

        return linea;

    }
}
