/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Streaming;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Joaquín
 */
public class CreaListaStreaming {

    private String ext;

    public CreaListaStreaming() {
    }

    public void creaFichero(String directorio) {

        File dir = new File(directorio);
        String[] ficheros = dir.list();
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter("C:\\ConfigStreaming\\listaStreaming.txt");
                pw = new PrintWriter(fichero);
                for (int x = 0; x < ficheros.length; x++) {
                    ext = (ficheros[x].lastIndexOf(".")==-1)?"":ficheros[x].substring(ficheros[x].lastIndexOf(".")+1, ficheros[x].length());
                    if(ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("avi")){
                        pw.println(ficheros[x]);
                    }
                }
            } catch (Exception e) {
                System.out.println("Falló la cración de la lista Streaming: " + e.getMessage());
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
    }
}
