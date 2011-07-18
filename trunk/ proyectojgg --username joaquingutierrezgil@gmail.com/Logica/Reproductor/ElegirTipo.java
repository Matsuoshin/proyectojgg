/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica.Reproductor;

import Reproductor.MedioStrategy;
import Reproductor.Video;
import java.io.File;

/**
 *
 * @author joaquin
 */
public class ElegirTipo {

    private MedioStrategy medio = null;

    public ElegirTipo(){

    }

    public MedioStrategy seleccionaMedio(File archivo){

        String fileName = archivo.getName();
        String ext = (fileName.lastIndexOf(".")==-1)?"":fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        
        if(ext.equalsIgnoreCase("mp3")){
            if(medio==null){
                //Llamo a la clase que reproduce Audio.
                medio = new Audio();
            }else{
                medio.destroyPipeline();
                medio = new Audio();
            }
        }else if(ext.equalsIgnoreCase("avi") || ext.equalsIgnoreCase("flv")){
            //Llamo a la calse que reproduce AVIs.
            medio = new Video();
        }else{
            System.out.println("Archivo no soportado.");
        }

        return medio;
    }

    public MedioStrategy seleccionaURL(String archivo){

        //String fileName = archivo.getName();
        String fileName = archivo;
        String ext = (fileName.lastIndexOf(".")==-1)?"":fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());

        if(ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("mp3\\")){
            if(medio==null){
                //Llamo a la clase que reproduce Audio.  
                medio = new Audio();
            }else{
                //medio.stop();
                medio.destroyPipeline();
                medio = new Audio();
            }
        }else if(ext.equalsIgnoreCase("avi")){
            //Llamo a la calse que reproduce AVIs.
            medio = new Video();
        }else{
            System.out.println("Archivo no soportado.");
        }

        return medio;
    }
}
